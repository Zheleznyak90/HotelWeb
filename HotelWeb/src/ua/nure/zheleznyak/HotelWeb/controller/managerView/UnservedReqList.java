package ua.nure.zheleznyak.HotelWeb.controller.managerView;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlManegerDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.Request;

/**
 * Servlet prepare data for jsp, that create list of all unserded requests.
 */
@WebServlet("/manager/RequestList")
public class UnservedReqList extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7567234398865631429L;

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
		List<Request> unserved = MysqlManegerDAO.getSingleton().getUnservedRequests();
		request.setAttribute("requests", unserved);
		request.setAttribute("jspPage", "requests");
		request.getRequestDispatcher("/view/pages/manager/managerPagePattern.jsp").forward(request, response);
	}
}
