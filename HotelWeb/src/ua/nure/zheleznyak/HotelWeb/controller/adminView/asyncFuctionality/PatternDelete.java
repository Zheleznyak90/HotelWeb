package ua.nure.zheleznyak.HotelWeb.controller.adminView.asyncFuctionality;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlAdminDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

/**
 * Servlet implementation class PatternDelete
 */
@WebServlet("/admin/PatternDelete")
public class PatternDelete extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1624999523766891926L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processReq(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processReq(request, response);
	}

	private void processReq(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int deleteId = Integer.parseInt(request.getParameter("id"));
		int code = MysqlAdminDAO.getSingleton().deletePattern(deleteId);
		response.setContentType("text/plain");
		response.getWriter().print(code);
	}

}
