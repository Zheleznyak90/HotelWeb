package ua.nure.zheleznyak.HotelWeb.controller.common.asyncFuctionality;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LangChange
 */
@WebServlet("/LangChange")
public class LangChange extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7480045192119133034L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lang = request.getParameter("lang");
		System.out.println(lang);
		HttpSession userSession = request.getSession();
		userSession.setAttribute("sessionLang", lang);
	}

}
