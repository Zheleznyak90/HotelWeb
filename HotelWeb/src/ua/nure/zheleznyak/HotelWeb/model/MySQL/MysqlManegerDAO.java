package ua.nure.zheleznyak.HotelWeb.model.MySQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ua.nure.zheleznyak.HotelWeb.model.SQLPatterns;
import ua.nure.zheleznyak.HotelWeb.model.DAO.ManagerDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.FillBean;
import ua.nure.zheleznyak.HotelWeb.model.structure.Order;
import ua.nure.zheleznyak.HotelWeb.model.structure.OrderStatus;
import ua.nure.zheleznyak.HotelWeb.model.structure.Request;
import ua.nure.zheleznyak.HotelWeb.model.structure.Room;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

public class MysqlManegerDAO implements ManagerDAO {
	private static final Logger logger = LogManager
			.getLogger(MysqlManegerDAO.class.getName());
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
			ResultSet rs = stm.executeQuery(SQLPatterns.GET_ORDERS+SQLPatterns.UNEXPIRED_ORDERS);
			while (rs.next()) {
				orders.add(FillBean.getSingleton().generateOrder(rs));
			}
		} catch (SQLException e) {
			logger.error("SQL ERROR", e);
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
		/*
		 * Connection con = null; try { con =
		 * MySQLConnection.getSingleton().getConnection(); requests = new
		 * ArrayList<Request>(); PreparedStatement pst =
		 * con.prepareStatement(SQLPatterns)
		 * 
		 * } catch (SQLException e) { logger.error("SQL ERROR", e); } finally {
		 * MySQLConnection.getSingleton().closeConnection(con); }
		 */
		return requests;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public int offerRoom(Order order, String requestId) {
		Connection con = null;
		int resCode = 0;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			con.setAutoCommit(false);
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.OFFER_ROOM);
			pst.setInt(1, order.getRoom().getId());
			pst.setString(2, order.getClient().getEmail());
			pst.setString(3, order.getManager().getEmail());
			pst.setInt(4, order.getMeal().getId());
			pst.setDate(5, order.getCreationDate());
			pst.setDate(6, order.getCheckInDate());
			pst.setDate(7, order.getCheckOutDate());
			pst.setString(8, requestId);
			System.out.println(pst);
			pst.executeUpdate();
			
			pst = con.prepareStatement(SQLPatterns.PROC_REQUEST);
			pst.setInt(1, order.getRoom().getId());
			pst.setString(2, order.getManager().getEmail());
			pst.setString(3, requestId);
			pst.executeUpdate();
			System.out.println(pst);
			con.commit();
			
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				logger.error("Failed rollback", e1);
			}
			logger.error("SQL ERROR", e);
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return resCode;
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
	public List<Request> getUnservedRequests() {
		List<Request> requests = null;
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			requests = new ArrayList<Request>();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(SQLPatterns.GET_UNSERVED_REQUESTS);
			while (rs.next()) {
				requests.add(FillBean.getSingleton().generateRequest(rs));
			}
		} catch (SQLException e) {
			logger.error("SQL ERROR", e);
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return requests;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Order getOrderById(String id) {
		Order currOrder = null;
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pstm = con
					.prepareStatement(SQLPatterns.GET_ORDERS+SQLPatterns.ORDER_BY_ID);

			pstm.setString(1, id);
			ResultSet rs = pstm.executeQuery();
			rs.next();
			currOrder = FillBean.getSingleton().generateOrder(rs);
		} catch (SQLException e) {
			logger.error("SQL ERROR", e);

		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return currOrder;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<OrderStatus> getStatusList() {
		Connection con = null;
		List<OrderStatus> statuses = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			statuses = new ArrayList<OrderStatus>();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(SQLPatterns.GET_STATUS_LIST);
			while (rs.next()) {
				OrderStatus currStat = new OrderStatus();
				currStat.setId(rs.getInt("id"));
				currStat.setStatus(rs.getString("status"));
				statuses.add(currStat);
			}

		} catch (SQLException e) {
			logger.error("SQL ERROR", e);
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return statuses;
	}

	@Override
	public List<Room> getAvailableRooms(Date checkIn, Date checkOut,
			String roomClass) {
		List<Room> roomList = new ArrayList<Room>();
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.GET_SPARE_ROOMS + SQLPatterns.SPARE_ROOM_BY_CLASS);
			pst.setDate(1, checkOut);
			pst.setDate(2, checkIn);
			pst.setString(3, roomClass);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				roomList.add(FillBean.getSingleton().generateRoom(rs));
			}

		} catch (SQLException e) {
			logger.error("SQL ERROR", e);
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return roomList;

	}

	@Override
	public Request getRequestById(String id) {
		Connection con = null;
		Request request = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.GET_REQUEST_BY_ID);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			rs.next();
			request = FillBean.getSingleton().generateRequest(rs);

		} catch (SQLException e) {
			logger.error("SQL ERROR", e);
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return request;
	}

}
