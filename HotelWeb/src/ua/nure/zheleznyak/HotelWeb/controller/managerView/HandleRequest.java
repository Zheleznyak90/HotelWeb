package ua.nure.zheleznyak.HotelWeb.controller.managerView;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlCommonDAO;
import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlManegerDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.ApartmentClass;
import ua.nure.zheleznyak.HotelWeb.model.structure.Request;
import ua.nure.zheleznyak.HotelWeb.model.structure.Room;

/**
 * Servlet implementation class HandleRequest
 */
@WebServlet("/manager/HandleRequest")
public class HandleRequest extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2712320832371813495L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Request currReq = MysqlManegerDAO.getSingleton().getRequestById(id);
		Date checkIn = null;
		Date checkOut = null;
		String aClass = null;

		try {
			DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			if (request.getParameterMap().containsKey("checkInDate")) {
				checkIn = new java.sql.Date(sdf.parse(
						request.getParameter("checkInDate")).getTime());
			} else {
				checkIn = currReq.getCheckInDate();
			}
			if (request.getParameterMap().containsKey("checkOutDate")) {
				checkOut = new java.sql.Date(sdf.parse(
						request.getParameter("checkOutDate")).getTime());
			} else {
				checkOut = currReq.getCheckOutDate();
			}
			if(request.getParameterMap().containsKey("class_id")){
				aClass = request.getParameter("class_id");
			}else{
				aClass = currReq.getaClass().getaClass();
			}
		} catch (ParseException e) {

			e.printStackTrace();
		}
		List<ApartmentClass> aClasses = MysqlCommonDAO.getSingleton().getApClasses();
		List<Room> availableRooms = MysqlManegerDAO.getSingleton()
				.getAvailableRooms(checkIn, checkOut, aClass);
		
		
		request.setAttribute("aClass", aClass);
		request.setAttribute("checkInDate", checkIn);
		request.setAttribute("checkOutDate", checkOut);
		request.setAttribute("aClasses", aClasses);
		request.setAttribute("request", currReq);
		request.setAttribute("rooms", availableRooms);
		request.setAttribute("jspPage", "createOrderOnReq");
		request.getRequestDispatcher(
				"/view/pages/manager/managerPagePattern.jsp").forward(request,
				response);

	}

}
