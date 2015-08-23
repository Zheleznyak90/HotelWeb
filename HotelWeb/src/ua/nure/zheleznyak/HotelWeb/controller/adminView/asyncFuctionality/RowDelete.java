package ua.nure.zheleznyak.HotelWeb.controller.adminView.asyncFuctionality;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlAdminDAO;

/**
 * Servlet allow async row deleting. 
 */
@WebServlet("/admin/RowDelete")
public class RowDelete extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1624999523766891926L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deleteId = Integer.parseInt(request.getParameter("id"));
		String table = request.getParameter("table");
		int code = MysqlAdminDAO.getSingleton().deleteField(table, deleteId);
		response.setContentType("text/plain");
		response.getWriter().print(code);
	}
}
