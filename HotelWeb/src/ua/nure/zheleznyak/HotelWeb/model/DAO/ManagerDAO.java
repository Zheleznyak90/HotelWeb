package ua.nure.zheleznyak.HotelWeb.model.DAO;

import java.sql.Date;
import java.util.List;

import ua.nure.zheleznyak.HotelWeb.model.structure.Order;
import ua.nure.zheleznyak.HotelWeb.model.structure.OrderStatus;
import ua.nure.zheleznyak.HotelWeb.model.structure.Request;
import ua.nure.zheleznyak.HotelWeb.model.structure.Room;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

public interface ManagerDAO {
	/**
	 * Return List of Order objects where checkIn date is further the current date based on database.
	 */
	public List<Order> getUnexpiredOrders();
	/**
	 * Return List of Order objects for single user based on database.
	 */
	public List<Order> getClientOrders(String email);
	/**
	 * Return List of Request objects that haven't been served yet based on database.
	 */
	public List<Request> getUnservedRequests();
	/**
	 * Return List of Request objects for single user based on database.
	 */
	public List<Request> getClientRequests(String email);
	/**
	 * Create single Request object using database row with passed id.
	 */
	public Request getRequestById(String id);
	/**
	 * Create single Order object using database row with passed id.
	 */
	public Order getOrderById(String id);
	/**
	 * Return List of OrderStatus objects based on database.
	 */
	public List<OrderStatus> getStatusList();
	
	/**
	 * Return List of Room objects based on database, that are free in assigned
	 * period and belongs to the roomClass.
	 */
	public List<Room> getAvailableRooms(Date checkIn, Date checkOut,
			String roomClass);
	
	public int offerRoom(Order order, int clientId, User manager);
	
	public boolean confirmBooking(int roomId, int clientId);
	public boolean confirmBookingCancel();
	public boolean showStat();
}
