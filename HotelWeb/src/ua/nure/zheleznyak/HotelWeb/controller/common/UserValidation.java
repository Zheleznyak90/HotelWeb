package ua.nure.zheleznyak.HotelWeb.controller.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlCommonDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;


/**
 * Servlet implementation class UserValidation
 */
@WebServlet("/UserValidation")
public class UserValidation extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7466333530644352759L;

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
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User currUser = MysqlCommonDAO.getSingleton().validateUser(email, password);
		if (currUser == null) {
			request.setAttribute("isInvalid", 1);
			request.getRequestDispatcher("authorization.jsp").forward(request,
					response);

		} else {
			String userRole = currUser.getRole();

			switch (userRole) {
			case "client":
				HttpSession userSession = request.getSession();
				userSession.setAttribute("User", currUser);
				response.sendRedirect("ClientMain");

				break;
			case "manager":
				HttpSession managerSession = request.getSession();
				managerSession.setAttribute("User", currUser);
				response.sendRedirect("Manager/ManagerMain");
				break;
				
			case "admin":
				HttpSession adminSession = request.getSession();
				adminSession.setAttribute("User", currUser);
				response.sendRedirect("Admin/AdminMain");
				break;
			}
		}

	}


}
