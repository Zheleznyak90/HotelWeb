package ua.nure.zheleznyak.HotelWeb.controller.adminView.edit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlAdminDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.Meal;

/**
 * Servlet search for meal using its id and pass meal entity to jsp for it's editing.
 */
@WebServlet("/admin/MealEdit")
public class MealEdit extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2053104710996131208L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Meal currMeal = MysqlAdminDAO.getSingleton().getMealById(id);
		request.setAttribute("meal", currMeal);
		request.setAttribute("jspPage", "edit/meal");
		request.getRequestDispatcher("/WEB-INF/pages/admin/adminPagePattern.jsp").forward(request, response);
	}

}
