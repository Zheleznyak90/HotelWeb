package ua.nure.zheleznyak.HotelWeb.controller.common.asyncFuctionality;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlCommonDAO;

/**
 * Servlet return result of unique field value checking.
 */
@WebServlet("/UniqueCheck")
public class UniqueCheck extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7877989622500032006L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String table = request.getParameter("table");
		String field = request.getParameter("field");
		Object value = request.getParameter("value");
		int resCode = MysqlCommonDAO.getSingleton().isUnique(table, field, value);
		response.setContentType("text/plain");
		response.getWriter().print(resCode);
	}

}
