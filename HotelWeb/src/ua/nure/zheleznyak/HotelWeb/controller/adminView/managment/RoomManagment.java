package ua.nure.zheleznyak.HotelWeb.controller.adminView.managment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlAdminDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.Room;

/**
 * Servlet get room list from database and pass it to jsp page.implementation class RoomManagment
 */
@WebServlet("/admin/RoomManagment")
public class RoomManagment extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2967905392951717674L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processReq(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processReq(request, response);
	}

	private void processReq(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<Room> rooms = MysqlAdminDAO.getSingleton().getRoomList();
		request.setAttribute("rooms", rooms);
		request.setAttribute("jspPage", "list/room");
		request.getRequestDispatcher("/WEB-INF/pages/admin/adminPagePattern.jsp").forward(request, response);
	}
}
