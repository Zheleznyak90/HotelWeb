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
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(SQLPatterns.GET_ROOM_CLASSES);
			while (rs.next()) {
				classes.add(rs.getString("class"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}
		return classes;
	}

	@Override
	public int createRequest(Request req) {
		Connection con = null;
		try {
			con = MySQLConnection.getSingleton().getConnection();
			PreparedStatement pst = con.prepareStatement(SQLPatterns.ROOM_REQUEST);
			pst.setString(1, req.getClient().getEmail());
			pst.setInt(2,req.getNumberOfPerson());
			pst.setDate(3, req.getCheckIn());
			pst.setDate(4, req.getCheckOut());
			pst.setDate(5, new Date(System.currentTimeMillis()));
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLConnection.getSingleton().closeConnection(con);
		}

		return 0;
	}

}
