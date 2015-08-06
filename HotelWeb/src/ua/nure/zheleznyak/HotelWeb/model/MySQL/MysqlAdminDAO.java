package ua.nure.zheleznyak.HotelWeb.model.MySQL;

import ua.nure.zheleznyak.HotelWeb.model.DAO.AdminDAO;

public class MysqlAdminDAO implements AdminDAO {
	
	private static final String SQL_GET_ALL_USERS= "SELECT login, password, fullName, email, role "
			+ "FROM user u, role r WHERE u.role_id = r.id";
	
	private static MysqlAdminDAO singleton;
	
	private MysqlAdminDAO (){}
	
	public static MysqlAdminDAO getInstance(){
		if(singleton == null){
			singleton = new MysqlAdminDAO ();
		}
		return singleton;
	}

	@Override
	public void getUsers() {}


	@Override
	public boolean deleteUser(String login) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(String email, String pass, String fullName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean promoteManager(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean demoteManager(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
