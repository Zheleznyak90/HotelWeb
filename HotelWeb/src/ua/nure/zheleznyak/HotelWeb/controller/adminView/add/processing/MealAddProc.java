package ua.nure.zheleznyak.HotelWeb.controller.adminView.add.processing;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlAdminDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.Meal;

/**
 * Servlet implementation class MealAddProc
 */
@WebServlet("/admin/MealAddProc")
public class MealAddProc extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1319064333387822596L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Meal newMeal = new Meal();
		int code = validate(request, newMeal);
		if (code == 0) {
			MysqlAdminDAO.getSingleton().addMeal(newMeal);
		} else {
			System.out.println("cannot add meal. Error: " + code);
			// TODO trace
		}
	}

	private int validate(HttpServletRequest request, Meal meal) {
		int code = 0;
		String name = request.getParameter("name");
		if (name.length() > 50 || name.isEmpty() || name == null)// TODO check
																	// unique
		{
			code += 1;
		} else {
			meal.setMeal(name);
		}
		String price = request.getParameter("price");
		if (price.isEmpty() || price == null || Double.parseDouble(price) < 0) {
			code += 10;
		} else {
			System.out.println(price);
			meal.setPrice(Double.parseDouble(price));
		}
		String description = request.getParameter("description");
		if (description == null) {
			code += 100;
		} else {
			meal.setDescription(description);
		}
		String isActive = request.getParameter("isActive");
		if (isActive == null) {
			meal.setActive(false);
		} else {
			meal.setActive(true);
		}

		return code;
	}

}
