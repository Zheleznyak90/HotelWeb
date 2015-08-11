package ua.nure.zheleznyak.HotelWeb.model.DAO;

import java.util.List;

import ua.nure.zheleznyak.HotelWeb.model.structure.Room;
import ua.nure.zheleznyak.HotelWeb.model.structure.RoomPattern;


public interface AdminDAO {
	
	public void getUsers();
	public boolean addUser(String email, String pass, String fullName);
	public boolean deleteUser(String email);
	
	public boolean promoteManager(String email);
	public boolean demoteManager(String email);
	
	public List<Room> getRoomList();
		
	public List<RoomPattern> getPatternList();
	public int deletePattern(int id);
		
}
