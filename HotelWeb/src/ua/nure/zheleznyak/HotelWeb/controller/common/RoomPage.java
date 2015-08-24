package ua.nure.zheleznyak.HotelWeb.controller.common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlCommonDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.RoomPattern;

/**
 * Servlet implementation class RoomPage
 */
@WebServlet("/RoomPage")
public class RoomPage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6929982358637203566L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		RoomPattern currRoom = MysqlCommonDAO.getSingleton().getPatternById(id);
		List<String> photoGallery = new ArrayList<String>();
		String photoPath = getServletContext().getRealPath(currRoom.getPhotoSetPath());
		File imageDir = new File(photoPath);
		for (File imageFile : imageDir.listFiles()) {
			String imageFileName = imageFile.getName();
			photoGallery.add(imageFileName);

		}
		request.setAttribute("photoGallery", photoGallery);
		request.setAttribute("pattern", currRoom);
		request.getRequestDispatcher("/view/pages/common/roomOverview.jsp").forward(request, response);
	}

}
