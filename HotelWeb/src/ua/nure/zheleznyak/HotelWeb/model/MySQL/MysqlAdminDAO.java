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
				RoomPattern currPattern = new RoomPattern();
				currPattern.setId(rs.getInt("id"));
				currPattern.setRoomClass(rs.getString("class"));
				currPattern.setPrice(rs.getInt("price"));
				currPattern.setSize(rs.getInt("size"));
				currPattern.setDescription(rs.getString("description"));
				currPattern.setPhotoSetPath(rs.getString("photoSetPath"));
				currPattern.setRating(rs.getFloat("rating"));
				patternList.add(currPattern);
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

			List<RoomPattern> patterns = getPatternList();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQLPatterns.GET_ROOM_LIST);
			while (rs.next()) {
				Room currRoom = new Room();
				currRoom.setId(rs.getInt("id"));
				int patternId = rs.getInt("room_pattern");

				currRoom.setFloor(rs.getInt("floor"));
				currRoom.setNumber(rs.getInt("number"));
				currRoom.setMaintained(rs.getBoolean("isMaintained"));
				for (RoomPattern currPattern : patterns) {
					if (currPattern.getId() == patternId) {
						currRoom.setPattern(currPattern);
						break;
					}
				}
				roomList.add(currRoom);
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
			PreparedStatement pst = con.prepareStatement(SQLPatterns.GET_USER_LIST);
			System.out.println(pst);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				User currUser = new User();
				currUser.setId(rs.getInt("id"));
				currUser.setEmail(rs.getString("email"));
				currUser.setFullName(rs.getString("fullName"));
				currUser.setPhoneNumber(rs.getString("PhoneNumber"));
				currUser.setRole(rs.getString("role"));
				userList.add(currUser);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return userList;
	}

	@Override
	public int addRoom(Room room) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<Meal> getMealsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addMeal(Meal meal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int changeFieldValue(String table, String field, int id, Object value) {
		Connection con = null;
		int resCode = 0;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.CHANGE_FIELD_P1+table+SQLPatterns.CHANGE_FIELD_P2+field+SQLPatterns.CHANGE_FIELD_P3);
			//Create statement UPDATE tableName SET fieldName=? WHERE id=?
			pst.setInt(1, id);
			pst.setString(2, value.toString());
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
					.prepareStatement(SQLPatterns.DELETE_ROW_P1+table+SQLPatterns.DELETE_ROW_P2);
			//Create statement DELETE FROM tableName WHERE id = ?
			
			pst.setInt(1, id);
			System.out.println(pst);
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
		// TODO Auto-generated method stub
		return 0;
	}

}
