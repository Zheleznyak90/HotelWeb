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
import ua.nure.zheleznyak.HotelWeb.model.structure.ApartmentClass;
import ua.nure.zheleznyak.HotelWeb.model.structure.FillBean;
import ua.nure.zheleznyak.HotelWeb.model.structure.Role;
import ua.nure.zheleznyak.HotelWeb.model.structure.RoomPattern;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

public class MysqlCommonDAO implements CommonDAO {

	private static MysqlCommonDAO singleton;

	private MysqlCommonDAO() {
	}

	public static MysqlCommonDAO getSingleton() {
		if (singleton == null) {
			singleton = new MysqlCommonDAO();
		}
		return singleton;
	}

	public User validateUser(String email, String password) {
		User currUser = null;
		Connection connection = null;
		try {
			connection = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = connection
					.prepareStatement(SQLPatterns.VERIFY_USER);
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (!rs.next()) {
				// Not valid login+pass
			} else {
				currUser = new User();
				currUser.setEmail(rs.getString("email"));
				currUser.setPassword(rs.getString("password"));
				currUser.setFullName(rs.getString("fullName"));
				currUser.setUserRole(getRoleById(rs.getInt("role_id")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(connection);
		}
		return currUser;
	}

	@Override
	public boolean registrateUser(User user) {
		Connection con = null;
		boolean isRegistered = false;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.REGISTRATE_USER);
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getFullName());
			pst.setString(4, user.getPhoneNumber());
			isRegistered = pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}

		return isRegistered;
	}

	@Override
	public List<RoomPattern> getRoomList() {
		List<RoomPattern> roomList = new ArrayList<RoomPattern>();
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQLPatterns.GET_ROOMS_MPAGE);
			while (rs.next()) {
				RoomPattern currPattern = new RoomPattern();
				currPattern.setaClass(getApClassById(rs.getInt("class_id")));
				currPattern.setPrice(rs.getInt("price"));
				currPattern.setSize(rs.getInt("size"));
				currPattern.setDescription(rs.getString("description"));
				currPattern.setName(rs.getString("name"));
				roomList.add(currPattern);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return roomList;
	}

	@Override
	public List<ApartmentClass> getApClasses() {
		List<ApartmentClass> apartmentClasses = null;
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			apartmentClasses = new ArrayList<ApartmentClass>();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.GET_APPARTMENT_CLASSES);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				apartmentClasses.add(FillBean.getSingleton()
						.generateApartmentClass(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return apartmentClasses;
	}

	@Override
	public ApartmentClass getApClassById(int id) {
		ApartmentClass currApartmentClass = null;
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.GET_APPARTMENT_CLASS_BY_ID);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			rs.next();
			currApartmentClass = FillBean.getSingleton()
					.generateApartmentClass(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return currApartmentClass;
	}
	
	@Override
	public List<Role> getRoles() {
		List<Role> roles = null;
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			roles = new ArrayList<Role>();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.GET_ROLES);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				roles.add(FillBean.getSingleton()
						.generateRole(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return roles;
		
	}

	@Override
	public Role getRoleById(int id) {
		Role currRole = null;
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.GET_ROLE_BY_ID);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			rs.next();
			currRole = FillBean.getSingleton()
					.generateRole(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return currRole;
	}

}
