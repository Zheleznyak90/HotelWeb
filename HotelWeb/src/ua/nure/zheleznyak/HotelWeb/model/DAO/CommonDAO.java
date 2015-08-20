package ua.nure.zheleznyak.HotelWeb.model.DAO;

import java.util.List;

import ua.nure.zheleznyak.HotelWeb.model.structure.ApartmentClass;
import ua.nure.zheleznyak.HotelWeb.model.structure.Role;
import ua.nure.zheleznyak.HotelWeb.model.structure.RoomPattern;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;


public interface CommonDAO {
	public User validateUser(String email, String password);
	public boolean registrateUser(User user);
	public List<RoomPattern> getPatternList();
	public RoomPattern getPatternById(String id);
	
	public List<ApartmentClass> getApClasses();
	public ApartmentClass getApClassById(int id);
	
	public List<Role> getRoles();
	public Role getRoleById(int id);
	
	public int isUnique(String table, String field, Object value);
}
