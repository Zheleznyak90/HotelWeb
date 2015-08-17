package ua.nure.zheleznyak.HotelWeb.controller.adminView;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlCommonDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.Role;

/**
 * Servlet implementation class UserAddInit
 */
@WebServlet("/admin/UserAddInit")
public class UserAddInit extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8901014480336204683L;

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
		List<Role> roles = MysqlCommonDAO.getSingleton().getRoles();
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("/view/pages/admin/mealAdd.jsp").forward(request, response);
	}


}
