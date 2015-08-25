package ua.nure.zheleznyak.HotelWeb.model.MySQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ua.nure.zheleznyak.HotelWeb.model.SQLPatterns;
import ua.nure.zheleznyak.HotelWeb.model.DAO.ClientDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.FillBean;
import ua.nure.zheleznyak.HotelWeb.model.structure.Meal;
import ua.nure.zheleznyak.HotelWeb.model.structure.Order;
import ua.nure.zheleznyak.HotelWeb.model.structure.Request;
import ua.nure.zheleznyak.HotelWeb.model.structure.Room;

public class MysqlClientDAO implements ClientDAO {
	private static final Logger logger = LogManager.getLogger(MysqlClientDAO.class.getName());

	private static MysqlClientDAO singleton;

	private MysqlClientDAO() {
	}
	/**
	 * Return singleton object.
	 */
	public static MysqlClientDAO getSingleton() {
		if (singleton == null) {
			singleton = new MysqlClientDAO();
		}
		return singleton;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void bookRoom(Order order, String roomPattern) {
		List<Room> spareRooms = getAvailableRooms(order.getCheckInDate(),
				order.getCheckOutDate(), roomPattern);
		if (!spareRooms.isEmpty()) {
			Connection con = null;
			try {
				con = MySQLConnection.getSingleton().getConnection();
				PreparedStatement pst = con
						.prepareStatement(SQLPatterns.BOOK_ROOM);
				pst.setInt(1, spareRooms.get(0).getId());
				pst.setString(2, order.getClient().getEmail());
				pst.setInt(3, order.getMeal().getId());
				pst.setDate(4, order.getCreationDate());
				pst.setDate(5, order.getCheckInDate());
				pst.setDate(6, order.getCheckOutDate());
				boolean res = pst.execute();

			} catch (SQLException e) {
				logger.error("SQL ERROR", e);
			} finally {
				MySQLConnection.getSingleton().closeConnection(con);
			}
		}

	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void confirmBook() {
		// TODO Auto-generated method stub

	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void cancelBook() {
		// TODO Auto-generated method stub

	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Meal> getMealList() {
		List<Meal> mealList = new ArrayList<Meal>();
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.GET_MEAL_LIST);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				mealList.add(FillBean.getSingleton().generateMeal(rs));
			}

		} catch (SQLException e) {
			logger.error("SQL ERROR", e);
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return mealList;

	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int createRequest(Request req) {
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.ROOM_REQUEST);
			pst.setString(1, req.getClient().getEmail());
			pst.setInt(2, req.getaClass().getId());
			pst.setInt(3, req.getNumberOfPerson());
			pst.setDate(4, new Date(System.currentTimeMillis()));
			pst.setDate(5, req.getCheckInDate());
			pst.setDate(6, req.getCheckOutDate());
			pst.execute();

		} catch (SQLException e) {
			logger.error("SQL ERROR", e);
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}

		return 0;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Room> getAvailableRooms(Date checkIn, Date checkOut,
			String roomPattern) {
		List<Room> roomList = new ArrayList<Room>();
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.GET_SPARE_ROOMS_BY_PATTERN);
			pst.setString(1, roomPattern);
			pst.setDate(2, checkIn);
			pst.setDate(3, checkOut);
			pst.setDate(4, checkIn);
			pst.setDate(5, checkOut);
			System.out.println(pst);
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
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> getClientOrders(String email) {
		List<Order> orders = null;
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			orders = new ArrayList<Order>();
			PreparedStatement pst = con.prepareStatement(SQLPatterns.GET_ORDERS+SQLPatterns.CLIENT_ORDERS);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				orders.add(FillBean.getSingleton().generateOrder(rs));
			}
		} catch (SQLException e) {
			logger.error("SQL ERROR", e);
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		// TODO Auto-generated method stub
		return orders;
	}
}
