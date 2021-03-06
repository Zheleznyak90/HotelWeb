package ua.nure.zheleznyak.HotelWeb.controller.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlCommonDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4209554147803411211L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User currUser = new User();
		currUser.setEmail(request.getParameter("email"));
		currUser.setPassword(request.getParameter("password"));
		currUser.setFullName(request.getParameter("fName"));
		currUser.setPhoneNumber(request.getParameter("phone"));
		int result = MysqlCommonDAO.getSingleton().registrateUser(currUser);
		if (result != 0) {
			request.getRequestDispatcher("/authorization").forward(request,
					response);
		} else {
			request.getRequestDispatcher("/registration").forward(request,
					response);
		}

	}

}
