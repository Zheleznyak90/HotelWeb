package ua.nure.zheleznyak.HotelWeb.model.DAO;

import java.util.List;

import ua.nure.zheleznyak.HotelWeb.model.structure.Request;


public interface ClientDAO {
	public void bookRoom();
	public void confirmBook();
	public void cancelBook();
	public List<String> getRoomClasses();
	public int createRequest(Request req);
}
