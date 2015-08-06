package ua.nure.zheleznyak.HotelWeb.model.MySQL;

import ua.nure.zheleznyak.HotelWeb.model.DAO.ClientDAO;

public class MysqlClientDAO implements ClientDAO {
	private static final String SQL_GET_ALL_USERS= "SELECT login, password, fullName, email, role "
			+ "FROM user u, role r WHERE u.role_id = r.id AND role = 'user'";

	@Override
	public void bookRoom() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmBook() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelBook() {
		// TODO Auto-generated method stub
		
	}


}
