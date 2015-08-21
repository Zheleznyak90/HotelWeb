package ua.nure.zheleznyak.HotelWeb.controller.adminView.asyncFuctionality;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlAdminDAO;

/**
 * Servlet allow async db editing. 
 */
@WebServlet("/admin/FieldEdit")
public class FieldEdit extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7894120813904399722L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String table = request.getParameter("table");
		String field = request.getParameter("field");	
		int id = Integer.parseInt(request.getParameter("id"));
		Object value = request.getParameter("value");
		
		int code = MysqlAdminDAO.getSingleton().changeFieldValue(table, field, id, value);
		response.setContentType("text/plain");
		response.getWriter().print(code);
		
	}

}
