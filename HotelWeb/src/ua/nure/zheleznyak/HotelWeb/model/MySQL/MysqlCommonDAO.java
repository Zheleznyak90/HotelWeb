package ua.nure.zheleznyak.HotelWeb.model.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.nure.zheleznyak.HotelWeb.model.SQLPatterns;
import ua.nure.zheleznyak.HotelWeb.model.DAO.CommonDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.RoomPattern;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

public class MysqlCommonDAO implements CommonDAO {
	
	private static MysqlCommonDAO singleton;
	
	private MysqlCommonDAO(){
	}
	
	public static MysqlCommonDAO getSingleton(){
		if(singleton == null){
			singleton = new MysqlCommonDAO();
		}
		return singleton;
	}
	
	public User validateUser(String email, String password) {
		User currUser = null;
		Connection connection = null;
		try {
			
			connection = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = connection.prepareStatement(SQLPatterns.VERIFY_USER);
			pst.setString(1, email);
			pst.setString(2, password);
			//System.out.println(pst);
			ResultSet rs = pst.executeQuery();
			if(!rs.next()){
				//Not valid login+pass
			}
			else{
				currUser = new User();
				//System.out.println(rs.getString("email"));
				currUser.setEmail(rs.getString("email"));
				
				//System.out.println(rs.getString("password"));
				currUser.setPassword(rs.getString("password"));
				
				//System.out.println(rs.getString("fullName"));
				currUser.setFullName(rs.getString("fullName"));
				
				//System.out.println(rs.getString("role"));
				currUser.setRole(rs.getString("role"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			MySQLConnection.getSingleton().closeConnection(connection);
		}
		return currUser;
	}

	@Override
	public boolean registrateUser(User user) {
		Connection con = null;
		boolean isRegistered = false;
		try{
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con.prepareStatement(SQLPatterns.REGISTRATE_USER);
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getFullName());
			pst.setString(4, user.getPhoneNumber());
			isRegistered = pst.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			MySQLConnection.getSingleton().closeConnection(con);
		}
		
		return isRegistered;
	}

	@Override
	public List<RoomPattern> getRoomList() {
		List<RoomPattern> roomList = new ArrayList<RoomPattern>();
		Connection con = null;
		try{
			con = MySQLConnection.getSingleton().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQLPatterns.GET_ROOM_LIST);
			while(rs.next()){
				RoomPattern currPattern = new RoomPattern();
				currPattern.setRoomClass(rs.getString("class"));
				currPattern.setPrice(rs.getInt("price"));
				currPattern.setSize(rs.getInt("size"));
				currPattern.setDescription(rs.getString("description"));
				currPattern.setPhotoSetPath(rs.getString("photoSetPath"));
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

/*	@Override
	public User getUSerByLogin(String login) {
		User currUser = null;
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement pst = connection.prepareStatement(SQL_GET_USER_BY_LOGIN);
			pst.setString(1, login);
			//System.out.println(pst);
			ResultSet rs = pst.executeQuery();
			if(!rs.next()){
				//Not valid login
			}
			else{
				currUser = new User();
				//System.out.println(rs.getString("email"));
				currUser.setEmail(rs.getString("email"));
				
				//System.out.println(rs.getString("login"));
				currUser.setLogin(rs.getString("login"));
				
				//System.out.println(rs.getString("password"));
				currUser.setPassword(rs.getString("password"));
				
				//System.out.println(rs.getString("fullName"));
				currUser.setFullName(rs.getString("fullName"));
				
				//System.out.println(rs.getString("role"));
				currUser.setRole(rs.getString("role"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			closeConnection(connection);
		}
		return currUser;
	}

*/}
