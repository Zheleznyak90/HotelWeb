package ua.nure.zheleznyak.HotelWeb.controller.adminView.edit;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlAdminDAO;
import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlCommonDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.Room;
import ua.nure.zheleznyak.HotelWeb.model.structure.RoomPattern;

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
		
		List<RoomPattern> patterns = MysqlCommonDAO.getSingleton().getPatternList();
		request.setAttribute("room", currRoom);
		request.setAttribute("patterns", patterns);
		request.setAttribute("jspPage", "edit/room");
		request.getRequestDispatcher("/view/pages/admin/adminPagePattern.jsp").forward(request, response);
	}
}
