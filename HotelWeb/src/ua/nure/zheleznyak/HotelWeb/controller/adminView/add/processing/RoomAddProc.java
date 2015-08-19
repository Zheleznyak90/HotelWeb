package ua.nure.zheleznyak.HotelWeb.controller.adminView.add.processing;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlAdminDAO;
import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlCommonDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.CommonFunc;
import ua.nure.zheleznyak.HotelWeb.model.structure.Room;

/**
 * Servlet implementation class MealAddProc
 */
@WebServlet("/admin/RoomAddProc")
public class RoomAddProc extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -997558870156839902L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Room newRoom = new Room();
		int code = validate(request, newRoom);
		if (code == 0) {
			MysqlAdminDAO.getSingleton().addRoom(newRoom);
			response.sendRedirect("RoomManagment");
		} else {
			System.out.println("cannot add room. Error: " + code);
			response.sendRedirect("RoomAddInit");
			// TODO trace
		}
	}

	private int validate(HttpServletRequest request, Room room) {
		int code = 0;
		String pattern = request.getParameter("pattern");
		if (pattern == null || pattern.isEmpty()
				|| !CommonFunc.isNumeric(pattern))// TODO check existing
		{
			code += 1;
		} else {
			room.getPattern().setId(Integer.parseInt(pattern));
		}
		String number = request.getParameter("number");
		if (number == null
				|| number.isEmpty()
				|| !CommonFunc.isNumeric(number)
				|| Integer.parseInt(number) < 0
				|| Integer.parseInt(number) > 999
				|| MysqlCommonDAO.getSingleton().isUnique("room", "number",
						number) != 0) {
			code += 10;
		} else {
			room.setNumber(Integer.parseInt(number));

		}

		String floor = request.getParameter("floor");
		if (floor == null || floor.isEmpty() || !CommonFunc.isNumeric(floor)
				|| Integer.parseInt(floor) < 0 || Integer.parseInt(floor) > 9) {// TODO
																				// get
																				// rid
																				// of
																				// hardcoded
																				// values
			code += 100;
		} else {
			room.setFloor(Integer.parseInt(floor));

		}
		String isMaintained = request.getParameter("isMaintained");
		if (isMaintained == null) {
			room.setMaintained(false);
		} else {
			room.setMaintained(true);
		}
		return code;
	}

}
