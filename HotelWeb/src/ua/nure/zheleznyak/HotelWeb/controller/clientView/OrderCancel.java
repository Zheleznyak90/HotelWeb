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
 * Servlet implementation class OrderCancel
 */
@WebServlet("/client/OrderCancel")
public class OrderCancel extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7687753767021557584L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		User currUser = (User) request.getSession().getAttribute("User");
		String email = currUser.getEmail();
		MysqlClientDAO.getSingleton().cancelBook(id, email);
		request.getRequestDispatcher("/client/MyOrders").forward(request, response);
		
	}

}
