package ua.nure.zheleznyak.HotelWeb.model.DAO;

import java.util.List;

import ua.nure.zheleznyak.HotelWeb.model.structure.Meal;
import ua.nure.zheleznyak.HotelWeb.model.structure.Room;
import ua.nure.zheleznyak.HotelWeb.model.structure.RoomPattern;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

public interface AdminDAO {
	/**
	 * Return List of User objects based on database.
	 */
	public List<User> getUsers();

	/**
	 * Create single User object using database row with passed id.
	 */
	public User getUserById(String id);

	/**
	 * Return List of Room objects based on database.
	 */
	public List<Room> getRoomList();

	/**
	 * Create single Room object using database row with passed id.
	 */
	public Room getRoomById(String id);

	/**
	 * Create new Room row in database, based on passed Room object.
	 */
	public int addRoom(Room room);

	/**
	 * Return List of RoomPattern objects based on database.
	 */
	public List<RoomPattern> getPatternList();

	/**
	 * Create new pattern row in database, based on passed RoomPattern object.
	 */
	public int addRoomPattern(RoomPattern pattern);

	/**
	 * Return List of meal objects based on database.
	 */
	public Meal getMealById(String id);

	/**
	 * Create new Meal row in database, based on passed Meal object.
	 */
	public int addMeal(Meal meal);

	/**
	 * Versatile method for editing single field in database.
	 */
	public int changeFieldValue(String table, String field, int id, Object value);

	/**
	 * Versatile method for deleting single row in database.
	 */
	public int deleteField(String table, int id);

}
