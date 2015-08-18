package ua.nure.zheleznyak.HotelWeb.model;

public class SQLPatterns {
	// Common sql requests
	public static final String VERIFY_USER = "SELECT email, password, fullName, role_id "
			+ "FROM userT WHERE email = ? AND password = ?";
	public static final String REGISTRATE_USER = "INSERT INTO userT(role_id, email, password, fullName, phoneNumber) VALUES "
			+ "(1, ?, ?, ?, ?)";
	public static final String GET_ROOMS_MPAGE = "SELECT class_id, size, price, description, name "
			+ "FROM room_pattern rp WHERE rp.id IN(SELECT room_pattern FROM room WHERE isMaintained = FALSE GROUP BY room_pattern HAVING COUNT(*)>0)";

	public static final String GET_APPARTMENT_CLASSES = "SELECT * FROM room_class";
	public static final String GET_APPARTMENT_CLASS_BY_ID = "SELECT * FROM room_class WHERE id = ?";
	
	public static final String GET_ROLES = "SELECT * FROM role";
	public static final String GET_ROLE_BY_ID = "SELECT * FROM role WHERE id = ?";
	
	// Administrator sql requests
	
	public static final String GET_USER_LIST = "SELECT id, role_id, email, fullName, phoneNumber FROM UserT ";
	public static final String GET_USER_BY_ID = "SELECT * FROM userT WHERE id =?";

	public static final String GET_PATTERN_LIST = "SELECT id, class_id, size, price, description, name, rating "
			+ "FROM room_pattern ";
	public static final String GET_PATTERN_BY_ID = "SELECT * FROM room_pattern WHERE id =?";
	public static final String ADD_ROOM_PATTERN = "INSERT INTO room_pattern(class_id, size, price) VALUES (? ,? ,?)";

	public static final String GET_MEAL_LIST = "SELECT * FROM meal";
	public static final String GET_MEAL_BY_ID = "SELECT * FROM meal WHERE id =?";
	public static final String ADD_MEAL = "INSERT INTO meal(meal, price, description, isActive) VALUES (?, ?, ?, ?)";

	public static final String GET_ROOM_LIST = "SELECT * FROM room";
	public static final String GET_ROOM_BY_ID = "SELECT * FROM room WHERE id =?";
	public static final String ADD_ROOM = "INSERT INTO room(room_pattern, status_id, number, floor) VALUES(?, ?, ?, ?)";

	public static final String CHANGE_FIELD_P1 = "UPDATE ";
	public static final String CHANGE_FIELD_P2 = " SET ";
	public static final String CHANGE_FIELD_P3 = " = ? WHERE id=?";

	public static final String DELETE_ROW_P1 = "DELETE FROM ";
	public static final String DELETE_ROW_P2 = " WHERE id = ?";

	// Manager sql requests
	public static final String OFFER_ROOM = "INSERT INTO orderT "
			+ "(room_id, client_id, manager_id, order_status, meal, created, checkIn_date, checkOut_date)"
			+ " VALUES (?, ?, ?, (SELECT id FROM order_status WHERE status='unconfirmed'), ?, ?, ?, ?)";
	public static final String CONFIRM_BOOKING_MANAGER = "UPDATE orderT SET order_status = '2' WHERE id = ?";
	public static final String GET_ALL_UNSERVED_REQUESTS = "SELECT number_of_person, checkIn_date, checkOut_date FROM request WHERE isServed=0 ORDER BY created DESC";
	public static final String GET_USER_REQUEST = "SELECT * FROM request WHERE user_id = ?";
	public static final String CONFIRM_BOOKING_CANCEL = "UPDATE orderT SET order_status = '3' WHERE id = ?";

	// Client sql requests
	public static final String CREATE_PERIOD = "INSERT INTO booking_period(checkIn_date, checkOut_date) "
			+ "VALUES (?,?)";
	public static final String GET_ROOM_CLASSES = "SELECT class FROM room_class";
	public static final String ROOM_REQUEST = "INSERT INTO request(client_id, number_of_person, booking_period, created) "
			+ "VALUES((SELECT id FROM userT WHERE email = ?),?,?,?)";
	public static final String BOOK_ROOM = "INSERT";
	public static final String CONFIRM_BOOKING_CLIENT = "UPDATE";
	public static final String CANCEL_BOOKING = "UPDATE";

	// public static final String VERIFY_USER = "";

}
