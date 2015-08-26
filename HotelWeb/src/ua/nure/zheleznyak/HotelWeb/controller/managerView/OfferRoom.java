package ua.nure.zheleznyak.HotelWeb.controller.managerView;

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
import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlManegerDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.Order;
import ua.nure.zheleznyak.HotelWeb.model.structure.Request;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

/**
 * Servlet implementation class OfferRoom
 */
@WebServlet("/manager/OfferRoom")
public class OfferRoom extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6364638322755157186L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order currOrder = new Order();
		HttpSession managerSession = request.getSession();
		currOrder.setManager((User) managerSession.getAttribute("User"));
		String id = request.getParameter("id");
		Request currReq = MysqlManegerDAO.getSingleton().getRequestById(id);
		currOrder.getMeal().setId(currReq.getMeal().getId());
		currOrder.getClient().setEmail(currReq.getClient().getEmail());
		currOrder.getRoom().setId(Integer.parseInt(request.getParameter("room_id")));

		try {
			DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date currDate = new Date();
			// Some strange convertation from MM/dd/yyyy to sql date format
			currOrder.setCheckInDate(new java.sql.Date(sdf.parse(
					request.getParameter("checkInDate")).getTime()));
			currOrder.setCheckOutDate(new java.sql.Date(sdf.parse(
					request.getParameter("checkOutDate")).getTime()));
			currOrder.setCreationDate(new java.sql.Date(currDate.getTime()));
			MysqlManegerDAO.getSingleton().offerRoom(currOrder, id);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("RequestList").forward(request, response);

	}

}
