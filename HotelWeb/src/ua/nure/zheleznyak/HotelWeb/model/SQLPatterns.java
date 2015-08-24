package ua.nure.zheleznyak.HotelWeb.model;

public class SQLPatterns {
	// Common sql requests
	public static final String VERIFY_USER = "SELECT email, password, fullName, role_id "
			+ "FROM userT WHERE email = ? AND password = ?";
	public static final String REGISTRATE_USER = "INSERT INTO userT(role_id, email, password, fullName, phoneNumber) VALUES "
			+ "(1, ?, ?, ?, ?)";
	public static final String GET_PATTERN_LIST = "SELECT id, class_id, size, price, description, name, rating "
			+ "FROM room_pattern ";
	public static final String GET_PATTERNS_WITHOUT_MAINTAINED_ROOMS = "SELECT id, class_id, size, price, description, name, rating "
			+ "FROM room_pattern WHERE id IN(SELECT room_pattern FROM room WHERE isMaintained = FALSE GROUP BY room_pattern )";

	public static final String GET_APPARTMENT_CLASSES = "SELECT * FROM room_class";
	public static final String GET_APPARTMENT_CLASS_BY_ID = "SELECT * FROM room_class WHERE id = ?";

	public static final String GET_ROLES = "SELECT * FROM role";
	public static final String GET_ROLE_BY_ID = "SELECT * FROM role WHERE id = ?";

	public static final String IS_UNIQUE_P1 = "SELECT id FROM ";
	public static final String IS_UNIQUE_P2 = " WHERE ";
	public static final String IS_UNIQUE_P3 = " = ?";

	// Administrator sql requests

	public static final String GET_USER_LIST = "SELECT id, role_id, email, fullName, phoneNumber FROM UserT ";
	public static final String GET_USER_BY_ID = "SELECT * FROM userT WHERE id =?";

	public static final String GET_PATTERN_BY_ID = "SELECT * FROM room_pattern WHERE id =?";
	public static final String ADD_ROOM_PATTERN = "INSERT INTO room_pattern(class_id, name, size, price, description) VALUES (? ,? ,?, ?, ?)";

	public static final String GET_MEAL_LIST = "SELECT * FROM meal";
	public static final String GET_MEAL_BY_ID = "SELECT * FROM meal WHERE id =?";
	public static final String ADD_MEAL = "INSERT INTO meal(name, price, description, isActive) VALUES (?, ?, ?, ?)";

	public static final String GET_ROOM_LIST = "SELECT * FROM room ORDER BY room_pattern";
	public static final String GET_ROOM_BY_ID = "SELECT * FROM room WHERE id =?";
	public static final String ADD_ROOM = "INSERT INTO room(room_pattern, number, floor, isMaintained) VALUES(?, ?, ?, ?)";

	public static final String CHANGE_FIELD_P1 = "UPDATE ";
	public static final String CHANGE_FIELD_P2 = " SET ";
	public static final String CHANGE_FIELD_P3 = " = ? WHERE id=?";

	public static final String DELETE_ROW_P1 = "DELETE FROM ";
	public static final String DELETE_ROW_P2 = " WHERE id = ?";

	// Manager sql requests
	public static final String GET_STATUS_LIST = "SELECT * FROM order_status";
	
	public static final String OFFER_ROOM = "INSERT INTO orderT "
			+ "(room_id, client_id, manager_id, order_status, meal, created, checkIn_date, checkOut_date)"
			+ " VALUES (?, ?, ?, (SELECT id FROM order_status WHERE status='unconfirmed'), ?, ?, ?, ?)";
	public static final String CONFIRM_BOOKING_MANAGER = "UPDATE orderT SET order_status = '2' WHERE id = ?";
	public static final String GET_USER_REQUEST = "SELECT * FROM request WHERE user_id = ?";
	public static final String CONFIRM_BOOKING_CANCEL = "UPDATE orderT SET order_status = '3' WHERE id = ?";

	public static final String GET_REQUEST_BY_ID ="SELECT r.id as id, c.email as client, man.email as manager," +
			" r.checkIn_date as checkIn, r.checkOut_date as checkOut, rc.class as aClass, r.number_of_person" +
			" FROM userT c," +
			" request r LEFT JOIN usert man ON man.id=r.manager_id," +
			" room_class rc" +
			" WHERE r.client_id=c.id AND r.class_id=rc.id AND r.id=?";
	
	public static final String GET_UNSERVED_REQUESTS = "SELECT r.id as id, c.email as client, man.email as manager," +
			" r.checkIn_date as checkIn, r.checkOut_date as checkOut, rc.class as aClass, r.number_of_person" +
			" FROM userT c," +
			" request r LEFT JOIN usert man ON man.id=r.manager_id," +
			" room_class rc" +
			" WHERE r.client_id=c.id AND r.class_id=rc.id AND isServed=0" +
			" AND r.checkIn_date>NOW()";
	
	public static final String GET_UNEXPIRED_ORDERS = "SELECT o.id, r.number as number, c.email as client, man.email as manager," +
			" m.name as meal, os.status as status, o.checkIn_date as checkIn, o.checkOut_date as checkOut" +
			" FROM userT c," +
			" orderT o LEFT JOIN usert man ON man.id=o.manager_id," +
			" room r, meal m, order_status os" +
			" WHERE o.client_id=c.id AND r.id = o.room_id AND" +
			" m.id = o.meal_id AND o.order_status = os.id AND o.checkIn_date>NOW()";
	public static final String GET_ORDER_BY_ID = "SELECT o.id, r.number as number, c.email as client, man.email as manager," +
			" m.name as meal, os.status as status, o.checkIn_date as checkIn, o.checkOut_date as checkOut" +
			" FROM userT c," +
			" orderT o LEFT JOIN usert man ON man.id=o.manager_id," +
			" room r, meal m, order_status os" +
			" WHERE o.client_id=c.id AND r.id = o.room_id AND" +
			" m.id = o.meal_id AND o.order_status = os.id AND o.id = ?";
	public static final String GET_USER_ORDERS = "SELECT o.id, r.number as number, c.email as client, man.email as manager," +
			" m.name as meal, os.status as status, o.checkIn_date as checkIn, o.checkOut_date as checkOut" +
			" FROM userT c," +
			" orderT o LEFT JOIN usert man ON man.id=o.manager_id," +
			" room r, meal m, order_status os" +
			" WHERE o.client_id=c.id AND r.id = o.room_id AND" +
			" m.id = o.meal_id AND o.order_status = os.id AND c.email = ?";
	public static final String GET_SPARE_ROOMS_BY_CLASS = "SELECT r.*"
			+ " FROM room r LEFT JOIN room_pattern rp ON(rp.id=r.room_pattern)" 
			+ " LEFT JOIN room_class rc ON( rc.id=rp.class_id)"
			+ " LEFT JOIN orderT o ON(r.id = o.room_id)" + " WHERE rc.class=? "
			+ " AND r.isMaintained = 0"
			+ " AND COALESCE((o.checkIn_date NOT BETWEEN ? AND ?), TRUE) "
			+ " AND COALESCE((o.checkOut_date NOT BETWEEN ? AND ?), TRUE)";
	// Client sql requests
	public static final String GET_SPARE_ROOMS_BY_PATTERN = "SELECT r.*"
			+ " FROM room r LEFT JOIN room_pattern rp ON(rp.id=r.room_pattern)"
			+ " LEFT JOIN orderT o ON(r.id = o.room_id)" + " WHERE rp.id=? "
			+ " AND r.isMaintained = 0"
			+ " AND COALESCE((o.checkIn_date NOT BETWEEN ? AND ?), TRUE) "
			+ " AND COALESCE((o.checkOut_date NOT BETWEEN ? AND ?), TRUE)";
	public static final String GET_ROOM_CLASSES = "SELECT class FROM room_class";
	public static final String ROOM_REQUEST = "INSERT INTO request(client_id, class_id, number_of_person, created, checkIn_date, checkOut_date) "
			+ "VALUES((SELECT id FROM userT WHERE email = ?), ?, ?, ?, ?, ?)";
	public static final String BOOK_ROOM = "INSERT INTO orderT "
			+ "(room_id, client_id, order_status, meal_id, created, checkIn_date, checkOut_date)"
			+ " VALUES (?, (SELECT id FROM userT WHERE email = ?), (SELECT id FROM order_status WHERE status='unconfirmed'), ?, ?, ?, ?)";
	public static final String CONFIRM_BOOKING_CLIENT = "UPDATE";
	public static final String CANCEL_BOOKING = "UPDATE";

}
/*
 * GET_PATTERNS_WITHOUT_MAINTAINED_ROOMS = "SELECT id, class_id, size, price,
 * description, name, rating FROM room_pattern WHERE id IN(SELECT room_pattern
 * FROM room WHERE isMaintained = FALSE GROUP BY room_pattern SELECT r.* FROM
 * room r LEFT JOIN room_pattern rp ON(rp.id=r.room_pattern) LEFT JOIN orderT o
 * ON(r.id = o.room_id) WHERE rp.id='1' AND COALESCE((o.checkIn_date NOT BETWEEN
 * '2015-08-20' AND '2015-08-21'), TRUE ) AND COALESCE((o.checkOut_date NOT
 * BETWEEN '2015-08-20' AND '2015-08-21'), TRUE)
 */

