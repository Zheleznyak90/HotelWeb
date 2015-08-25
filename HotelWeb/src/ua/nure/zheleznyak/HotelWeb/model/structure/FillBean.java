package ua.nure.zheleznyak.HotelWeb.model.structure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlCommonDAO;

public class FillBean {
	private static final Logger logger = LogManager.getLogger(MysqlCommonDAO.class.getName());

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
			currMeal.setName(rs.getString("name"));
			currMeal.setPrice(rs.getDouble("price"));
			currMeal.setActive(rs.getBoolean("isActive"));
			currMeal.setDescription(rs.getString("description"));
		} catch (SQLException e) {
			logger.error("SQL ERROR", e);
		}
		return currMeal;
	}

	public Room generateRoom(ResultSet rs) {
		Room currRoom = new Room();
		List<RoomPattern> patterns = MysqlCommonDAO.getSingleton()
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
			logger.error("SQL ERROR", e);
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
			currUser.setUserRole(MysqlCommonDAO.getSingleton().getRoleById(
					rs.getInt("role_id")));

		} catch (SQLException e) {
			logger.error("SQL ERROR", e);
		}
		return currUser;
	}

	public RoomPattern generateRoomPattern(ResultSet rs) {
		RoomPattern currPattern = new RoomPattern();
		try {
			currPattern.setId(rs.getInt("id"));
			currPattern.setaClass(MysqlCommonDAO.getSingleton().getApClassById(
					rs.getInt("class_id")));
			currPattern.setPrice(rs.getInt("price"));
			currPattern.setSize(rs.getInt("size"));
			currPattern.setDescription(rs.getString("description"));
			currPattern.setName(rs.getString("name"));
		} catch (SQLException e) {
			logger.error("SQL ERROR", e);
		}
		return currPattern;
	}

	public ApartmentClass generateApartmentClass(ResultSet rs) {
		ApartmentClass aClass = new ApartmentClass();
		try {
			aClass.setId(rs.getInt("id"));
			aClass.setaClass(rs.getString("class"));
		} catch (SQLException e) {
			logger.error("SQL ERROR", e);
		}
		return aClass;
	}
	
	public Request generateRequest(ResultSet rs){
		Request currReq = new Request();
		try {
			currReq.setId(rs.getInt("id"));
			currReq.getClient().setEmail(rs.getString("client"));
			currReq.getManager().setEmail(rs.getString("manager"));
			currReq.setNumberOfPerson(rs.getInt("number_of_person"));
			currReq.getaClass().setaClass(rs.getString("aClass"));
			currReq.setCheckInDate(rs.getDate("checkIn"));
			currReq.setCheckOutDate(rs.getDate("checkOut"));
		} catch (SQLException e) {
			logger.error("SQL ERROR", e);
		}
		return currReq;
	}
	
	
	public Order generateOrder(ResultSet rs){
		Order currOrder = new Order();
		try {
			currOrder.setId(rs.getInt("id"));
			currOrder.getClient().setEmail(rs.getString("client"));
			currOrder.getManager().setEmail(rs.getString("manager"));
			currOrder.getMeal().setName(rs.getString("meal"));
			currOrder.getRoom().setNumber(rs.getInt("number"));
			currOrder.getStatus().setStatus(rs.getString("status"));
			currOrder.setCheckInDate(rs.getDate("checkIn"));
			currOrder.setCheckOutDate(rs.getDate("checkOut"));
			currOrder.setPrice(rs.getDouble("price"));
		} catch (SQLException e) {
			logger.error("SQL ERROR", e);
		}
		return currOrder;
	}
		
	public Role generateRole(ResultSet rs) {
		Role currRole = new Role();
		try {
			currRole.setId(rs.getInt("id"));
			currRole.setRole(rs.getString("role"));
		} catch (SQLException e) {
			logger.error("SQL ERROR", e);
		}
		return currRole;
	}

}
