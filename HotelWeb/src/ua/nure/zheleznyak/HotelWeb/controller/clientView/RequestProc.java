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
import ua.nure.zheleznyak.HotelWeb.model.structure.BookingPeriod;
import ua.nure.zheleznyak.HotelWeb.model.structure.Request;
import ua.nure.zheleznyak.HotelWeb.model.structure.User;

/**
 * Servlet implementation class RequestProc
 */
@WebServlet("/client/RequestProc")
public class RequestProc extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4544445531898920968L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processReq(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processReq(request, response);
	}
	
	private void processReq(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession clientSession = request.getSession();
		User client = (User) clientSession.getAttribute("User");
		
		Request roomReq = new Request();
		roomReq.setClient(client);
		roomReq.setNumberOfPerson(Integer.parseInt(request.getParameter("num")));
		roomReq.setApartmentClass((String) request.getParameter("class"));
		
		try {
			DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date currDate = new Date();
			BookingPeriod bp = new BookingPeriod();
			//Some strange convertation from MM/dd/yyyy to sql date format
			bp.setCheckInDate(new java.sql.Date (sdf.parse(request.getParameter("checkInDate")).getTime()));
			bp.setCheckOutDate(new java.sql.Date (sdf.parse(request.getParameter("checkOutDate")).getTime()));
			roomReq.setPeriod(bp);
			roomReq.setCreated(new java.sql.Date (currDate.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int requestExec = MysqlClientDAO.getSingleton().createRequest(roomReq);
		
		request.getRequestDispatcher("/view/pages/tnxForRequest.jsp").forward(request, response);
	}

}