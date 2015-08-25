package ua.nure.zheleznyak.HotelWeb.controller.clientView;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlClientDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

/**
 * Servlet implementation class OrderConfirm
 */
@WebServlet("/client/OrderConfirm")
public class OrderConfirm extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3256631694558935652L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		User currUser = (User) request.getSession().getAttribute("User");
		String email = currUser.getEmail();
		MysqlClientDAO.getSingleton().confirmBook(id, email);
		request.getRequestDispatcher("/client/MyOrders").forward(request, response);
		
	}

}
