package ua.nure.zheleznyak.HotelWeb.controller.clientView;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlClientDAO;
import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlCommonDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.Meal;
import ua.nure.zheleznyak.HotelWeb.model.structure.RoomPattern;

/**
 * Servlet search for pattern using its id and pass pattern entity to jsp for order initialization.
 */
@WebServlet("/client/OrderInit")
public class OrderInit extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6047217795582937734L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String patternId = request.getParameter("id");
		RoomPattern pattern = MysqlCommonDAO.getSingleton().getPatternById(patternId);
		List<Meal> meals = MysqlClientDAO.getSingleton().getMealList();
		request.setAttribute("pattern", pattern);
		request.setAttribute("meals", meals);
		request.getRequestDispatcher("/view/pages/client/orderRoom.jsp").forward(request, response);
	}

}
