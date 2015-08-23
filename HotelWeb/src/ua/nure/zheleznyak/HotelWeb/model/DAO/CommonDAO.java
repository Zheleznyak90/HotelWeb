package ua.nure.zheleznyak.HotelWeb.model.DAO;

import java.util.List;

import ua.nure.zheleznyak.HotelWeb.model.structure.ApartmentClass;
import ua.nure.zheleznyak.HotelWeb.model.structure.Role;
import ua.nure.zheleznyak.HotelWeb.model.structure.RoomPattern;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

public interface CommonDAO {
	/**
	 * Check user existence inside database and return User object if user
	 * valid.
	 * */
	public User validateUser(String email, String password);

	/**
	 * Create new User row in database, based on passed User object.
	 */
	public int registrateUser(User user);

	/**
	 * Return List of RoomPattern objects based on database. List doesn't
	 * contain patterns without any room or woth all maintained rooms.
	 */
	public List<RoomPattern> getPatternList();

	/**
	 * Create single RoomPattern object using database row with passed id.
	 */
	public RoomPattern getPatternById(String id);

	/**
	 * Return List of ApartmentClass objects based on database.
	 */
	public List<ApartmentClass> getApClasses();

	/**
	 * Create single AppartmentClass object using database row with passed id.
	 */
	public ApartmentClass getApClassById(int id);

	/**
	 * Return List of User objects based on database.
	 */
	public List<Role> getRoles();

	/**
	 * Create single Role object using database row with passed id.
	 */
	public Role getRoleById(int id);

	/**
	 * Versatile method for checking uniqueness of field value.
	 */
	public int isUnique(String table, String field, Object value);
}
