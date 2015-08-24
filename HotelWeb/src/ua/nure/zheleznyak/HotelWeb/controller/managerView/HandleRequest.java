package ua.nure.zheleznyak.HotelWeb.controller.managerView;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlManegerDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.Request;
import ua.nure.zheleznyak.HotelWeb.model.structure.Room;

/**
 * Servlet implementation class HandleRequest
 */
@WebServlet("/manager/HandleRequest")
public class HandleRequest extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Request currReq = MysqlManegerDAO.getSingleton().getRequestById(id);
		List<Room> availableRooms = MysqlManegerDAO.getSingleton().getAvailableRooms(currReq.getCheckInDate(), currReq.getCheckOutDate(), currReq.getaClass().getaClass());
		System.out.println(availableRooms.size());
	}

}
