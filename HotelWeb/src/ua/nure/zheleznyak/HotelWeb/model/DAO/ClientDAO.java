package ua.nure.zheleznyak.HotelWeb.model.DAO;

import java.sql.Date;
import java.util.List;

import ua.nure.zheleznyak.HotelWeb.model.structure.Meal;
import ua.nure.zheleznyak.HotelWeb.model.structure.Order;
import ua.nure.zheleznyak.HotelWeb.model.structure.Request;
import ua.nure.zheleznyak.HotelWeb.model.structure.Room;

public interface ClientDAO {
	/**
	 * Create new Order row in database, based on passed Order object and RoomPattern id.
	 */
	public void bookRoom(Order order, String roomPattern);

	public void confirmBook();

	public void cancelBook();

	/**
	 * Return List of Meal objects based on database.
	 */
	public List<Meal> getMealList();

	/**
	 * Create new Request row in database, based on passed Request object.
	 */
	public int createRequest(Request req);

	/**
	 * Return List of Room objects based on database, that are free in assigned
	 * period and belongs to the roomPattern.
	 */
	public List<Room> getAvailableRooms(Date checkIn, Date checkOut,
			String roomPattern);
}
