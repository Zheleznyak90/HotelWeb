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
import ua.nure.zheleznyak.HotelWeb.model.structure.Role;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

/**
 * Servlet search for user using its id and pass user entity to jsp for it's editing.
 */
@WebServlet("/admin/UserEdit")
public class UserEdit extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6504882992447684664L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		User currUser = MysqlAdminDAO.getSingleton().getUserById(id);
		List<Role> roles = MysqlCommonDAO.getSingleton().getRoles();
		request.setAttribute("user", currUser);
		request.setAttribute("roles", roles);
		request.setAttribute("jspPage", "edit/user");
		request.getRequestDispatcher("/view/pages/admin/adminPagePattern.jsp").forward(request, response);
	}
}
