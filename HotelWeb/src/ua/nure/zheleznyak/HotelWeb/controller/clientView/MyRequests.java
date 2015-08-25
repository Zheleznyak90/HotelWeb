package ua.nure.zheleznyak.HotelWeb.controller.clientView;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyRequests
 */
@WebServlet("/client/MyRequests")
public class MyRequests extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4232983520442853608L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processReq(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processReq(request, response);
	}

	private void processReq(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("jspPage", "myRequest");
		request.getRequestDispatcher("/view/pages/client/clientPagePattern.jsp").forward(request, response);
	}


}
