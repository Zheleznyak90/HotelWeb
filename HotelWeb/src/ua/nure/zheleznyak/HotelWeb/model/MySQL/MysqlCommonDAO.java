package ua.nure.zheleznyak.HotelWeb.model.MySQL;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
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
import ua.nure.zheleznyak.HotelWeb.model.structure.CommonFunc;
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
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.VERIFY_USER);
			pst.setString(1, email);
			String hashedPass = CommonFunc.hashPass(password);
			pst.setString(2, hashedPass);
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
			MySQLConnection.getSingleton().closeConnection(con);
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
			String hashedPass = CommonFunc.hashPass(user.getPassword());
			
			pst.setString(2, hashedPass);
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
	public List<RoomPattern> getPatternList() {
		List<RoomPattern> patternList = new ArrayList<RoomPattern>();
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQLPatterns.GET_PATTERN_LIST);
			while (rs.next()) {
				patternList
						.add(FillBean.getSingleton().generateRoomPattern(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return patternList;
	}
	
	@Override
	public RoomPattern getPatternById(String id) {
		RoomPattern currRoomPattern = null;
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.GET_PATTERN_BY_ID);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			rs.next();
			currRoomPattern = FillBean.getSingleton().generateRoomPattern(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return currRoomPattern;
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

	@Override
	public int isUnique(String table, String field, Object value) {
		Connection con = null;
		int resCode = 0;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con
					.prepareStatement(SQLPatterns.IS_UNIQUE_P1 + table
							+ SQLPatterns.IS_UNIQUE_P2 +field +SQLPatterns.IS_UNIQUE_P3);
			// Create statement SELECT id FROM tableName WHERE fieldName = ?

			pst.setObject(1, value);
			ResultSet rs = pst.executeQuery();
			if (rs.isBeforeFirst() ) {    
				 resCode = 300; 
			}
		} catch (SQLException e) {
			e.printStackTrace();
			resCode = 301;
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return resCode;

	}

}
