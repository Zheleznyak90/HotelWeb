package ua.nure.zheleznyak.HotelWeb.controller.adminView;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlAdminDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.RoomPattern;

/**
 * Servlet implementation class PatternManagment
 */
@WebServlet("/admin/PatternManagment")
public class PatternManagment extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1445773309452786757L;

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
		List<RoomPattern> patterns = MysqlAdminDAO.getSingleton().getPatternList();
		request.setAttribute("patterns", patterns);
		request.setAttribute("jspPage", "list/pattern");
		request.getRequestDispatcher("/view/pages/admin/adminPagePattern.jsp").forward(request, response);
	}
}
