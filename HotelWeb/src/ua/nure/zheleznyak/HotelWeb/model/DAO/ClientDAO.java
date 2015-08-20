package ua.nure.zheleznyak.HotelWeb.model.DAO;

import java.sql.Date;
import java.util.List;

import ua.nure.zheleznyak.HotelWeb.model.structure.Meal;
import ua.nure.zheleznyak.HotelWeb.model.structure.Order;
import ua.nure.zheleznyak.HotelWeb.model.structure.Request;
import ua.nure.zheleznyak.HotelWeb.model.structure.Room;


public interface ClientDAO {
	public void bookRoom(Order order, String roomPattern);
	public void confirmBook();
	public void cancelBook();
	
	public List<Meal> getMealList();
	public int createRequest(Request req);
	public List<Room> getAvailableRooms(Date checkIn, Date checkOut, String roomPattern);
}
