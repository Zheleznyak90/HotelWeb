package ua.nure.zheleznyak.HotelWeb.controller.clientView;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlClientDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.Order;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

/**
 * Servlet implementation class MyOrders
 */
@WebServlet("/client/MyOrders")
public class MyOrders extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8047403801913118814L;

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
		User currUser = (User) request.getSession().getAttribute("User");
		List<Order> orders = MysqlClientDAO.getSingleton().getClientOrders(currUser.getEmail());
		request.setAttribute("orders", orders);
		request.setAttribute("jspPage", "myOrders");
		request.getRequestDispatcher("/WEB-INF/pages/client/clientPagePattern.jsp").forward(request, response);

	}

}
