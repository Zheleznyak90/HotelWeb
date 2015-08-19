package ua.nure.zheleznyak.HotelWeb.model.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.nure.zheleznyak.HotelWeb.model.SQLPatterns;
import ua.nure.zheleznyak.HotelWeb.model.DAO.AdminDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.FillBean;
import ua.nure.zheleznyak.HotelWeb.model.structure.Meal;
import ua.nure.zheleznyak.HotelWeb.model.structure.Room;
import ua.nure.zheleznyak.HotelWeb.model.structure.RoomPattern;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

public class MysqlAdminDAO implements AdminDAO {

	private static MysqlAdminDAO singleton;

	private MysqlAdminDAO() {
	}

	public static MysqlAdminDAO getSingleton() {
		if (singleton == null) {
			singleton = new MysqlAdminDAO();
		}
		return singleton;
	}

	@Override
	public List<RoomPattern> getPatternList() {
		List<RoomPattern> patternList = new ArrayList<RoomPattern>();
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQLPatterns.GET_PATTERN_LIST);
			while (rs.next()) {
				patternList
						.add(FillBean.getSingleton().generateRoomPattern(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return patternList;
	}

	@Override
	public List<Room> getRoomList() {
		List<Room> roomList = new ArrayList<Room>();
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQLPatterns.GET_ROOM_LIST);
			while (rs.next()) {
				roomList.add(FillBean.getSingleton().generateRoom(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return roomList;
	}

	@Override
	public List<User> getUsers() {
		List<User> userList = new ArrayList<User>();
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.GET_USER_LIST);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				userList.add(FillBean.getSingleton().generateUser(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return userList;
	}

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
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return mealList;

	}

	@Override
	public int changeFieldValue(String table, String field, int id, Object value) {
		Connection con = null;
		int resCode = 0;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.CHANGE_FIELD_P1 + table
							+ SQLPatterns.CHANGE_FIELD_P2 + field
							+ SQLPatterns.CHANGE_FIELD_P3);
			// Create statement UPDATE tableName SET fieldName=? WHERE id=?
			pst.setInt(2, id);
			pst.setObject(1, value);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			resCode = 301;
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return resCode;
	}

	@Override
	public int deleteField(String table, int id) {
		Connection con = null;
		int resCode = 0;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.DELETE_ROW_P1 + table
							+ SQLPatterns.DELETE_ROW_P2);
			// Create statement DELETE FROM tableName WHERE id = ?

			pst.setInt(1, id);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			resCode = 301;
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return resCode;
	}

	@Override
	public int addRoomPattern(RoomPattern pattern) {
		Connection con = null;
		int errCode = 0;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.ADD_ROOM_PATTERN);
			pst.setInt(1, pattern.getaClass().getId());
			pst.setString(2, pattern.getName());
			pst.setInt(3, pattern.getSize());
			pst.setDouble(4, pattern.getPrice());
			pst.setString(5, pattern.getDescription());
			pst.execute();
		} catch (SQLException e) {
			errCode = 301;
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}

		return errCode;
	}

	@Override
	public int addMeal(Meal meal) {
		Connection con = null;
		int errCode = 0;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con.prepareStatement(SQLPatterns.ADD_MEAL);
			pst.setString(1, meal.getName());
			pst.setDouble(2, meal.getPrice());
			pst.setString(3, meal.getDescription());
			pst.setBoolean(4, meal.isActive());
			pst.execute();
		} catch (SQLException e) {
			errCode = 301;
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}

		return errCode;
	}

	@Override
	public int addRoom(Room room) {
		Connection con = null;
		int errCode = 0;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con.prepareStatement(SQLPatterns.ADD_ROOM);
			pst.setInt(1, room.getPattern().getId());
			pst.setInt(2, room.getNumber());
			pst.setInt(3, room.getFloor());
			pst.setBoolean(4, room.isMaintained());
			pst.execute();
		} catch (SQLException e) {
			errCode = 301;
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}

		return errCode;
	}

	@Override
	public User getUserById(String id) {
		User currUser = null;
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.GET_USER_BY_ID);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			rs.next();
			currUser = FillBean.getSingleton().generateUser(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return currUser;
	}

	@Override
	public Room getRoomById(String id) {
		Room currRoom = null;
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.GET_ROOM_BY_ID);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			rs.next();
			currRoom = FillBean.getSingleton().generateRoom(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return currRoom;
	}

	@Override
	public RoomPattern getPatternById(String id) {
		RoomPattern currRoomPattern = null;
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.GET_PATTERN_BY_ID);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			rs.next();
			currRoomPattern = FillBean.getSingleton().generateRoomPattern(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return currRoomPattern;
	}

	@Override
	public Meal getMealById(String id) {
		Meal currMeal = null;
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.GET_MEAL_BY_ID);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			rs.next();
			currMeal = FillBean.getSingleton().generateMeal(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return currMeal;
	}
}
