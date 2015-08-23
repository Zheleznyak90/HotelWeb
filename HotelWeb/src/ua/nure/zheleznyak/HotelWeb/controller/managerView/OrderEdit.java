package ua.nure.zheleznyak.HotelWeb.controller.managerView;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlClientDAO;
import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlManegerDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.Meal;
import ua.nure.zheleznyak.HotelWeb.model.structure.Order;
import ua.nure.zheleznyak.HotelWeb.model.structure.OrderStatus;

/**
 * Servlet prepare data for jsp, that create editable order instance.
 */
@WebServlet("/manager/OrderEdit")
public class OrderEdit extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1758014892515497179L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Order currOrder = MysqlManegerDAO.getSingleton().getOrderById(id);
		List<Meal> meals = MysqlClientDAO.getSingleton().getMealList();
		List<OrderStatus> statuses = MysqlManegerDAO.getSingleton().getStatusList();
		request.setAttribute("order", currOrder);
		request.setAttribute("meals", meals);
		request.setAttribute("statuses", statuses);
		request.setAttribute("jspPage", "orderEdit");
		request.getRequestDispatcher("/view/pages/manager/managerPagePattern.jsp").forward(request, response);
	}

}
