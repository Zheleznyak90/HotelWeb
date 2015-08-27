package ua.nure.zheleznyak.HotelWeb.controller.managerView;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlManegerDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.Order;

/**
 * Servlet prepare data for jsp, that create list of all unexpired orders.
 */
@WebServlet("/manager/OrdersList")
public class UnexpiredOrdersList extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8954030487965599574L;

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
		List<Order> unexpired = MysqlManegerDAO.getSingleton().getUnexpiredOrders();
		request.setAttribute("orders", unexpired);
		request.setAttribute("jspPage", "orders");
		request.getRequestDispatcher("/WEB-INF/pages/manager/managerPagePattern.jsp").forward(request, response);
		
	}

}