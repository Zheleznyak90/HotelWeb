package ua.nure.zheleznyak.HotelWeb.model.MySQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.nure.zheleznyak.HotelWeb.model.SQLPatterns;
import ua.nure.zheleznyak.HotelWeb.model.DAO.ClientDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.Request;

public class MysqlClientDAO implements ClientDAO {

	private static MysqlClientDAO singleton;

	private MysqlClientDAO() {
	}

	public static MysqlClientDAO getSingleton() {
		if (singleton == null) {
			singleton = new MysqlClientDAO();
		}
		return singleton;
	}

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

	@Override
	public List<String> getRoomClasses() {
		List<String> classes = null;
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			classes = new ArrayList<String>();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQLPatterns.GET_ROOM_CLASSES);
			while (rs.next()) {
				classes.add(rs.getString("class"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classes;
	}

	@Override
	public int createRequest(Request req) {
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con.prepareStatement(
					SQLPatterns.CREATE_PERIOD, Statement.RETURN_GENERATED_KEYS);
			pst.setDate(1, req.getPeriod().getCheckInDate());
			pst.setDate(2, req.getPeriod().getCheckOutDate());
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				pst = con.prepareStatement(SQLPatterns.ROOM_REQUEST);
				pst.setString(1, req.getClient().getEmail());
				pst.setInt(2, req.getNumberOfPerson());
				pst.setLong(3, rs.getLong(1));
				pst.setDate(4, new Date(System.currentTimeMillis()));
				pst.execute();

			} else {
				// SQL problems code
				return 301;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}

		return 0;
	}

}
