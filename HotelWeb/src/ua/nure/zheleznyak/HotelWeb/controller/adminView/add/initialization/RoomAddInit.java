package ua.nure.zheleznyak.HotelWeb.controller.adminView.add.initialization;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlCommonDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.RoomPattern;

/**
 * Servlet implementation class RoomAddInit
 */
@WebServlet("/admin/RoomAddInit")
public class RoomAddInit extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8063274577303836628L;

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
		List<RoomPattern> patterns = MysqlCommonDAO.getSingleton().getPatternList();
		request.setAttribute("patterns", patterns);
		request.setAttribute("jspPage", "add/room");
		request.getRequestDispatcher("/view/pages/admin/adminPagePattern.jsp").forward(request, response);
	}

}
