package ua.nure.zheleznyak.HotelWeb.controller.adminView;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.zheleznyak.HotelWeb.model.structure.User;

/**
 * Servlet Filter implementation class IsAdmin
 */
@WebFilter(urlPatterns = { "/admin/*" })
public class IsAdmin implements Filter {

	/**
	 * Default constructor.
	 */
	public IsAdmin() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		User currUser = (User) ((HttpServletRequest) request).getSession().getAttribute("User");
		if ( currUser == null || !currUser.getRole().equals("admin")) {
			String contextPath = ((HttpServletRequest)request).getContextPath();
			((HttpServletResponse) response).sendRedirect(contextPath+"/authorization");
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
