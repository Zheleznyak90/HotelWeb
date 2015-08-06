package ua.nure.zheleznyak.HotelWeb.model.DAO;


public interface AdminDAO {
	public void getUsers();
	public boolean addUser(String email, String pass, String fullName);
	public boolean deleteUser(String email);
	public boolean promoteManager(String email);
	public boolean demoteManager(String email);
		
}
