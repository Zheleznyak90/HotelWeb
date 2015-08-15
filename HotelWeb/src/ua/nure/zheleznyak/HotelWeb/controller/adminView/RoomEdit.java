package ua.nure.zheleznyak.HotelWeb.controller.adminView;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlAdminDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.Room;

/**
 * Servlet implementation class RoomEdit
 */
@WebServlet("/admin/RoomEdit")
public class RoomEdit extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -860834026603067447L;

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
		String id = request.getParameter("id");
		Room currRoom = MysqlAdminDAO.getSingleton().getRoomById(id);
		// TODO List<String> patterns=
		// MysqlAdminDAO.getSingleton().getPatternsName();
		request.setAttribute("room", currRoom);
		// request.setAttribute("patterns", patterns);
		request.getRequestDispatcher("/view/pages/admin/roomEdit.jsp").forward(
				request, response);
	}
}
