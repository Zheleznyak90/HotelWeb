package ua.nure.zheleznyak.HotelWeb.controller.adminView;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.structure.User;

/**
 * Servlet implementation class AdminMain
 */
@WebServlet("/Admin/AdminMain")
public class AdminMain extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5252569357905658249L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processReq(request, response);
	}

	private void processReq(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User u = (User) request.getSession().getAttribute("User");
		response.getWriter().print(u.getRole());
	}
}
