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
	/**
	 * Return singleton object.
	 */
	public static MysqlManegerDAO getSingleton() {
		if (singleton == null) {
			singleton = new MysqlManegerDAO();
		}
		return singleton;
	}
	/**
	 * {@inheritDoc}
	 */
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
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Request> getClientRequests(String email) {
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
	/**
	 * {@inheritDoc}
	 */
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
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean confirmBooking(int roomId, int clientId) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean confirmBookingCancel() {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean showStat() {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> getClientOrders(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Request> getUnservedRequests() {
		// TODO Auto-generated method stub
		return null;
	}

}
