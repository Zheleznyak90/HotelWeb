package ua.nure.zheleznyak.HotelWeb.controller.adminView.managment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlAdminDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

/**
 * Servlet get user list from database and pass it to jsp page.
 */
@WebServlet("/admin/UserManagment")
public class UserManagment extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4987682219979014131L;

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
		List<User> users = MysqlAdminDAO.getSingleton().getUsers();
		request.setAttribute("users", users);
		request.setAttribute("jspPage", "list/user");
		request.getRequestDispatcher("/view/pages/admin/adminPagePattern.jsp").forward(request, response);
	}
}
