package ua.nure.zheleznyak.HotelWeb.controller.adminView.add.processing;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlAdminDAO;
import ua.nure.zheleznyak.HotelWeb.model.MySQL.MysqlCommonDAO;
import ua.nure.zheleznyak.HotelWeb.model.structure.CommonFunc;
import ua.nure.zheleznyak.HotelWeb.model.structure.RoomPattern;

/**
 * Servlet validate incoming date and create new pattern entity in database.
 */
@WebServlet("/admin/PatternAddProc")
@MultipartConfig
public class PatternAddProc extends HttpServlet {
	private static final Logger logger = LogManager.getLogger(PatternAddProc.class.getName());
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -188973041729896465L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RoomPattern newPattern = new RoomPattern();
		
		int code = validate(request, newPattern);
		if (code == 0) {
			String photoPath = getServletContext().getRealPath(newPattern.getPhotoSetPath());
			File photoDir = new File(photoPath);
			if (!photoDir.exists()) {
				if (photoDir.mkdir()) {
				    Part filePart = request.getPart("file_1"); 
				    String fileName = getSubmittedFileName(filePart);
				    InputStream fileContent = filePart.getInputStream();
				} 
			}
			
			MysqlAdminDAO.getSingleton().addRoomPattern(newPattern);
			response.sendRedirect("PatternManagment");
		} else {
			logger.trace("Cannot add pattern. Error: " + code);
			response.sendRedirect("PatternAddInit");
			
		}
	}

	private int validate(HttpServletRequest request, RoomPattern pattern) {
		int code = 0;
		String name = request.getParameter("name");
		if (name == null
				|| name.isEmpty()
				|| name.length() > 50
				|| MysqlCommonDAO.getSingleton().isUnique("room_pattern", "name", name) != 0)
		{
			code += 1;
		} else {
			pattern.setName(name);
		}
		String classId = request.getParameter("class_id");
		if (classId == null || classId.isEmpty()
				|| !CommonFunc.isNumeric(classId))
		{
			code += 10;
		} else {
			pattern.getaClass().setId(Integer.parseInt(classId));
		}
		String price = request.getParameter("price");
		if (price == null || price.isEmpty() || !CommonFunc.isNumeric(price)
				|| Double.parseDouble(price) < 0) {
			code += 100;
		} else {
			pattern.setPrice(Double.parseDouble(price));

		}
		String size = request.getParameter("size");
		if (size == null || size.isEmpty() || !CommonFunc.isNumeric(size)
				|| Integer.parseInt(size) < 0 || Integer.parseInt(size) > 10) {
			code += 1000;
		} else {
			pattern.setSize(Integer.parseInt(size));

		}
		String description = request.getParameter("description");
		pattern.setDescription(description);

		return code;
	}
	
	private static String getSubmittedFileName(Part part) {
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;
	}

}
