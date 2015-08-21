package ua.nure.zheleznyak.HotelWeb.controller.clientView;

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
 * Servlet filter any /client/ request and grant access only for authorized users.
 */
@WebFilter(urlPatterns = { "/client/*" })
public class IsClient implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		User currUser = (User) ((HttpServletRequest) request).getSession().getAttribute("User");
		if ( currUser == null) {
			String contextPath = ((HttpServletRequest)request).getContextPath();
			((HttpServletResponse) response).sendRedirect(contextPath+"/m");
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
