package ua.nure.zheleznyak.HotelWeb.controller.adminView.add.initialization;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlCommonDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.ApartmentClass;

/**
 * Servlet implementation class PatternAddInit
 */
@WebServlet("/admin/PatternAddInit")
public class PatternAddInit extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3456361361499855228L;

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
		List<ApartmentClass> classes = MysqlCommonDAO.getSingleton().getApClasses();
		request.setAttribute("classes", classes);
		request.setAttribute("jspPage", "add/pattern");
		request.getRequestDispatcher("/view/pages/admin/adminPagePattern.jsp").forward(request, response);
	}
}
