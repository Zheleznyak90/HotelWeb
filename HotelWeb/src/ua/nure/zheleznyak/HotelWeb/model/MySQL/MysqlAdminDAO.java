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
	public boolean deleteUser(String login) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(String email, String pass, String fullName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean promoteManager(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean demoteManager(String email) {
		// TODO Auto-generated method stub
		return false;
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
	public int deletePattern(int id) {
		Connection con = null;
		int resCode = 0;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.DELETE_ROOM_PATTERN);
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
	public int deleteRoom() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addRoom(Room room) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addPattern(RoomPattern pattern) {
		// TODO Auto-generated method stub
		return 0;
	}

}
