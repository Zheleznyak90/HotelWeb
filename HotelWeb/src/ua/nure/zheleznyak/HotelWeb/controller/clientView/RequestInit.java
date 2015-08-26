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
import ua.nure.zheleznyak.HotelWeb.model.structure.ApartmentClass;
import ua.nure.zheleznyak.HotelWeb.model.structure.Meal;

/**
 * Servlet prepare data for new request jsp page.
 */
@WebServlet("/client/RequestInit")
public class RequestInit extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3532435645621573110L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processReq(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processReq(request, response);
	}
	
	private void processReq(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<ApartmentClass> classes = MysqlCommonDAO.getSingleton().getApClasses();
		List<Meal> meals = MysqlClientDAO.getSingleton().getMealList();
		request.setAttribute("classes", classes);
		request.setAttribute("meals", meals);
		request.getRequestDispatcher("/view/pages/client/request.jsp").forward(request, response);
	}

}
