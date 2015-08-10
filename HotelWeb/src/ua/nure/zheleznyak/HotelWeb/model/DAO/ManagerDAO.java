package ua.nure.zheleznyak.HotelWeb.model.DAO;

import java.util.List;

import ua.nure.zheleznyak.HotelWeb.model.structure.Order;
import ua.nure.zheleznyak.HotelWeb.model.structure.Request;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

public interface ManagerDAO {
	public boolean showAllBookingRequests();
	public List<Request> showClientRequests();
	public int offerRoom(Order order, int clientId, User manager);
	public boolean confirmBooking(int roomId, int clientId);
	public boolean confirmBookingCancel();
	public boolean showStat();
}
