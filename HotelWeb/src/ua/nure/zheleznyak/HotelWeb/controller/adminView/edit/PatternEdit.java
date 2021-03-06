package ua.nure.zheleznyak.HotelWeb.controller.adminView.edit;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlCommonDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.ApartmentClass;
import ua.nure.zheleznyak.HotelWeb.model.structure.RoomPattern;

/**
 * Servlet search for pattern using its id and pass pattern entity to jsp for it's editing.
 */
@WebServlet("/admin/PatternEdit")
public class PatternEdit extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8017576581778428687L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		RoomPattern currPattern = MysqlCommonDAO.getSingleton().getPatternById(id);
		List<ApartmentClass> classes = MysqlCommonDAO.getSingleton().getApClasses();
		request.setAttribute("pattern", currPattern);
		request.setAttribute("classes", classes);
		request.setAttribute("jspPage", "edit/pattern");
		request.getRequestDispatcher("/view/pages/admin/adminPagePattern.jsp").forward(request, response);
	}

}
