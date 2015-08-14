package ua.nure.zheleznyak.HotelWeb.controller.adminView;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlAdminDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

/**
 * Servlet implementation class UserEdit
 */
@WebServlet("/admin/UserEdit")
public class UserEdit extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6504882992447684664L;

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
		User currUser = MysqlAdminDAO.getSingleton().getUserById(id);
		// TODO List<String> roles = MysqlAdminDAO.getSingleton().getRoleList();
		request.setAttribute("user", currUser);
		//request.setAttribute("roles", roles);
		request.getRequestDispatcher("/view/pages/admin/userEdit.jsp").forward(request, response);
	}

}
