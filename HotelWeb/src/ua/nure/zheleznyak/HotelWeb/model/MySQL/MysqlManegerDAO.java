package ua.nure.zheleznyak.HotelWeb.model.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.nure.zheleznyak.HotelWeb.model.SQLPatterns;
import ua.nure.zheleznyak.HotelWeb.model.DAO.ManagerDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.Order;
import ua.nure.zheleznyak.HotelWeb.model.structure.Request;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

public class MysqlManegerDAO implements ManagerDAO {
	private static MysqlManegerDAO singleton;

	private MysqlManegerDAO() {
	}

	public static MysqlManegerDAO getSingleton() {
		if (singleton == null) {
			singleton = new MysqlManegerDAO();
		}
		return singleton;
	}

	@Override
	public List<Order> getUnexpiredOrders() {
		List<Order> orders = null;
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			orders = new ArrayList<Order>();
			Statement stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery(SQLPatterns.GET_UNEXPIRED_ORDERS);
			while (rs.next()) {
				Order currOrder = new Order();
				currOrder.getClient().setEmail(rs.getString("client"));
				currOrder.getManager().setEmail(rs.getString("manager"));
				currOrder.getMeal().setName(rs.getString("meal"));
				currOrder.getRoom().setNumber(rs.getInt("number"));
				currOrder.getStatus().setStatus(rs.getString("status"));
				currOrder.setCheckInDate(rs.getDate("checkIn"));
				currOrder.setCheckOutDate(rs.getDate("checkOut"));
				orders.add(currOrder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return orders;
	}

	@Override
	public List<Request> showClientRequests(String email) {
		List<Request> requests = null;
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			requests = new ArrayList<Request>();
			Statement stm = con.createStatement();
			System.out.println(SQLPatterns.GET_ALL_UNSERVED_REQUESTS);
			ResultSet rs = stm
					.executeQuery(SQLPatterns.GET_ALL_UNSERVED_REQUESTS);
			while (rs.next()) {
				Request currReq = new Request();
				currReq.setNumberOfPerson(rs.getInt("number_of_person"));
				currReq.setCheckInDate(rs.getDate("checkIn_date"));
				currReq.setCheckOutDate(rs.getDate("checkOut_date"));
				requests.add(currReq);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return requests;
	}

	@Override
	public int offerRoom(Order order, int clientId, User manager) {
		Connection con = null;
		int resCode = 0;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con.prepareStatement(SQLPatterns.OFFER_ROOM);
			//pst.set
			//ResultSet rs = stm.executeQuery(SQLPatterns.GET_ALL_UNSERVED_REQUESTS);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return resCode;
	}

	@Override
	public boolean confirmBooking(int roomId, int clientId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean confirmBookingCancel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean showStat() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Order> showClientOrders(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Request> showUnservedRequests() {
		// TODO Auto-generated method stub
		return null;
	}

}
