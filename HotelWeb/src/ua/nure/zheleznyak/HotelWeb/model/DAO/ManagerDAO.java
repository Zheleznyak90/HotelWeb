package ua.nure.zheleznyak.HotelWeb.model.DAO;

import java.util.List;

import ua.nure.zheleznyak.HotelWeb.model.structure.Order;
import ua.nure.zheleznyak.HotelWeb.model.structure.Request;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

public interface ManagerDAO {
	public List<Order> getUnexpiredOrders();
	public List<Order> showClientOrders(String email);
	
	public List<Request> showUnservedRequests();
	public List<Request> showClientRequests(String email);
	
	public int offerRoom(Order order, int clientId, User manager);
	
	public boolean confirmBooking(int roomId, int clientId);
	public boolean confirmBookingCancel();
	public boolean showStat();
}
