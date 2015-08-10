package ua.nure.zheleznyak.HotelWeb.model;

public class SQLPatterns {
	//Common sql requests
	public static final String VERIFY_USER = "SELECT email, password, fullName, role "
			+ "FROM userT u, role r WHERE u.role_id = r.id AND email = ? AND password = ?";
	public static final String REGISTRATE_USER = "INSERT INTO userT(role_id, email, password, fullName, phoneNumber) VALUES "
			+ "(1, ?, ?, ?, ?)";
	public static final String GET_ROOM_PATTERN = "SELECT class, size, price, description, photoSetPath "
			+ "FROM room_pattern rp, room_class rc "
			+ "WHERE rp.class_id = rc.id";
	public static final String GET_ROOM_LIST = "SELECT rc.class, rp.size, rp.price, COUNT(r.id) as amount"
			+ " FROM room_pattern rp, room r, room_status rs, room_class rc"
			+ " WHERE r.room_pattern = rp.id AND rp.class_id=rc.id AND r.status_id=rs.id "
			+ " GROUP BY rp.id";
	
	//Administrator sql requests
	public static final String ADD_USER = "";
	public static final String DELETE_USER = "";
	public static final String CHANGE_ROLE = "UPDATE userT SET role_id = ? WHERE id = ?";
	
	public static final String ADD_ROOM_PATTERN = "INSERT INTO room_pattern(class_id, size, price) VALUES (? ,? ,?)";
	public static final String CHANGE_ROOM_PRICE = "UPDATE room_pattern SET price = ? WHERE id = ?";
	public static final String CHANGE_ROOM_CLASS = "UPDATE room_pattern SET class_id = ? WHERE id = ?";
	public static final String CHANGE_ROOM_SIZE = "UPDATE room_pattern SET size = ? WHERE id = ?";
	public static final String CHANGE_ROOM_DESCRIPTION = "UPDATE room_pattern SET description = ? WHERE id = ?";
	//TODO delete room pattern
	
	public static final String ADD_ROOM = "INSERT INTO room(room_pattern, status_id, number, floor) VALUES(?, ?, ?, ?)";
	public static final String CHANGE_ROOM_STATUS = "UPDATE room SET status_id = ? WHERE id = ?";
	public static final String CHANGE_ROOM_PATTERN = "UPDATE room SET pattern_id = ? WHERE id = ?";
	//TODO delete room
	public static final String ADD_MEAL = "INSERT INTO meal(meal, price) VALUES (?, ?)";
	public static final String CHANGE_MEAL_PRICE = "UPDATE meal SET price = ? WHERE id = ?";
	//TODO delete meal
	//public static final String DELETE_MEAL = "UPDATE room SET price = ? WHERE id = ?";
	
	
	//Manager sql requests
	public static final String OFFER_ROOM = "INSERT INTO orderT "
			+ "(room_id, client_id, manager_id, order_status, meal, created, checkIn_date, checkOut_date)"
			+ " VALUES (?, ?, ?, (SELECT id FROM order_status WHERE status='unconfirmed'), ?, ?, ?, ?)";
	public static final String CONFIRM_BOOKING_MANAGER = "UPDATE orderT SET order_status = '2' WHERE id = ?";
	public static final String GET_ALL_UNSERVED_REQUESTS = "SELECT number_of_person, checkIn_date, checkOut_date FROM request WHERE isServed=0 ORDER BY created DESC";
	public static final String GET_USER_REQUEST = "SELECT * FROM request WHERE user_id = ?";
	public static final String CONFIRM_BOOKING_CANCEL = "UPDATE orderT SET order_status = '3' WHERE id = ?";
	
	//Client sql requests
	public static final String CREATE_PERIOD = "INSERT INTO booking_period(checkIn_date, checkOut_date) "
			+ "VALUES (?,?)";
	public static final String GET_ROOM_CLASSES = "SELECT class FROM room_class"; 
	public static final String ROOM_REQUEST = "INSERT INTO request(client_id, number_of_person, booking_period, created) "
			+ "VALUES((SELECT id FROM userT WHERE email = ?),?,?,?)";
	public static final String BOOK_ROOM = "INSERT";
	public static final String CONFIRM_BOOKING_CLIENT = "UPDATE";
	public static final String CANCEL_BOOKING = "UPDATE";
	
	//public static final String VERIFY_USER = "";
	
	
}
