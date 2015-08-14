package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlAdminDAO;

public class FillBean {
	private static FillBean singleton;

	private FillBean() {
	}

	public static FillBean getSingleton() {
		if (singleton == null) {
			singleton = new FillBean();
		}
		return singleton;
	}

	public Meal generateMeal(ResultSet rs) {
		Meal currMeal = new Meal();
		try {
			currMeal.setId(rs.getInt("id"));
			currMeal.setMeal(rs.getString("meal"));
			currMeal.setPrice(rs.getDouble("price"));
			currMeal.setActive(rs.getBoolean("isActive"));
			currMeal.setDescription(rs.getString("description"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currMeal;
	}

	public Room generateRoom(ResultSet rs) {
		Room currRoom = new Room();
		List<RoomPattern> patterns = MysqlAdminDAO.getSingleton()
				.getPatternList();

		try {
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

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currRoom;
	}

	public User generateUser(ResultSet rs) {
		User currUser = new User();
		try {
			currUser.setId(rs.getInt("id"));
			currUser.setEmail(rs.getString("email"));
			currUser.setFullName(rs.getString("fullName"));
			currUser.setPhoneNumber(rs.getString("PhoneNumber"));
			currUser.setRole(rs.getString("role"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currUser;
	}

	public RoomPattern generateRoomPattern(ResultSet rs) {
		RoomPattern currPattern = new RoomPattern();
		try {
			currPattern.setId(rs.getInt("id"));
			currPattern.setRoomClass(rs.getString("class"));
			currPattern.setPrice(rs.getInt("price"));
			currPattern.setSize(rs.getInt("size"));
			currPattern.setDescription(rs.getString("description"));
			currPattern.setPhotoSetPath(rs.getString("photoSetPath"));
			currPattern.setRating(rs.getFloat("rating"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currPattern;
	}

}
