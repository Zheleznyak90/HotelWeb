package ua.nure.zheleznyak.HotelWeb.model.DAO;

import java.util.List;

import ua.nure.zheleznyak.HotelWeb.model.structure.RoomPattern;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;


public interface CommonDAO {
	public User validateUser(String email, String password);
	public boolean registrateUser(User user);
	public List<RoomPattern> getRoomList();
}
