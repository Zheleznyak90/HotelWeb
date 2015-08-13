package ua.nure.zheleznyak.HotelWeb.model.DAO;

import java.util.List;

import ua.nure.zheleznyak.HotelWeb.model.structure.Meal;
import ua.nure.zheleznyak.HotelWeb.model.structure.Room;
import ua.nure.zheleznyak.HotelWeb.model.structure.RoomPattern;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;


public interface AdminDAO {
	
	public List<User> getUsers();
	public int addUser(User user);
	
	public List<Room> getRoomList();
	public int addRoom(Room room);
			
	public List<RoomPattern> getPatternList();
	public int addRoomPattern(RoomPattern pattern);
	
	public List<Meal> getMealsList();
	public int addMeal(Meal meal);
	
	public int changeFieldValue(String table, String field, int id, Object value);
	public int deleteField(String table, int id);
	
}
