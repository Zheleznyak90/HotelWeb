package ua.nure.zheleznyak.HotelWeb.model.MySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.nure.zheleznyak.HotelWeb.model.SQLPatterns;
import ua.nure.zheleznyak.HotelWeb.model.DAO.AdminDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.RoomPattern;

public class MysqlAdminDAO implements AdminDAO {
	
	private static MysqlAdminDAO singleton;
	
	private MysqlAdminDAO (){}
	
	public static MysqlAdminDAO getSingleton(){
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

	@Override
	public List<RoomPattern> getPatternList() {
		List<RoomPattern> roomList = new ArrayList<RoomPattern>();
		Connection con = null;
		try{
			con = MySQLConnection.getSingleton().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQLPatterns.GET_PATTERN_LIST);
			System.out.println(SQLPatterns.GET_PATTERN_LIST);
			while(rs.next()){
				RoomPattern currPattern = new RoomPattern();
				currPattern.setId(rs.getInt("id"));
				currPattern.setRoomClass(rs.getString("class"));
				currPattern.setPrice(rs.getInt("price"));
				currPattern.setSize(rs.getInt("size"));
				currPattern.setDescription(rs.getString("description"));
				currPattern.setPhotoSetPath(rs.getString("photoSetPath"));
				currPattern.setRating(rs.getFloat("rating"));
				roomList.add(currPattern);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return roomList;
	}

}
