package ua.nure.zheleznyak.HotelWeb.controller.adminView.managment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlClientDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.Meal;

/**
 * Servlet get meal list from database and pass it to jsp page.
 */
@WebServlet("/admin/MealManagment")
public class MealManagment extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7287010345355170954L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processReq(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processReq(request, response);
	}

	private void processReq(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Meal> meals = MysqlClientDAO.getSingleton().getMealList();
		request.setAttribute("meals", meals);
		request.setAttribute("jspPage", "list/meal");
		request.getRequestDispatcher("/WEB-INF/pages/admin/adminPagePattern.jsp").forward(request, response);
	}

}
