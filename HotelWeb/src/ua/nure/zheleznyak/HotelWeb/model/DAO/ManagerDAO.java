package ua.nure.zheleznyak.HotelWeb.model.DAO;

import java.util.List;

import ua.nure.zheleznyak.HotelWeb.model.structure.Order;
import ua.nure.zheleznyak.HotelWeb.model.structure.Request;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

public interface ManagerDAO {
	/**
	 * Return List of Order objects that checkIn date if further the current date based on database.
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
	
	public int offerRoom(Order order, int clientId, User manager);
	
	public boolean confirmBooking(int roomId, int clientId);
	public boolean confirmBookingCancel();
	public boolean showStat();
}
