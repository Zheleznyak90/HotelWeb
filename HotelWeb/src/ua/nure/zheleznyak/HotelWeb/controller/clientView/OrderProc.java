package ua.nure.zheleznyak.HotelWeb.controller.clientView;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlClientDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.Order;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

/**
 * Servlet implementation class OrderProc
 */
@WebServlet("/client/OrderProc")
public class OrderProc extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2553678448227167442L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Order currOrder = new Order();
		HttpSession clientSession = request.getSession();
		currOrder.setClient((User) clientSession.getAttribute("User"));
		currOrder.getMeal().setId(
				Integer.parseInt(request.getParameter("meal")));
		String patternId = request.getParameter("pattern_id");

		try {
			DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date currDate = new Date();
			// Some strange convertation from MM/dd/yyyy to sql date format
			currOrder.setCheckInDate(new java.sql.Date(sdf.parse(
					request.getParameter("checkInDate")).getTime()));
			currOrder.setCheckOutDate(new java.sql.Date(sdf.parse(
					request.getParameter("checkOutDate")).getTime()));
			currOrder.setCreationDate(new java.sql.Date(currDate.getTime()));
			MysqlClientDAO.getSingleton().bookRoom(currOrder, patternId);

		} catch (ParseException e) {// TODO SEND INVALID
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/view/pages/tnxForRequest.jsp").forward(request, response);
	}

}
