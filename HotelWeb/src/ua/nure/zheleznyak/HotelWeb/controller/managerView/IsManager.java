package ua.nure.zheleznyak.HotelWeb.controller.managerView;

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
 * Servlet filter any /manager/ request and grant access only for managers and
 * administrators.
 */
@WebFilter(urlPatterns = { "/manager/*" })
public class IsManager implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		User currUser = (User) ((HttpServletRequest) request).getSession()
				.getAttribute("User");
		if (currUser == null
				|| (!currUser.getUserRole().getRole().equals("admin") && !currUser
						.getUserRole().getRole().equals("manager"))) {
			System.out.println("WHY U HERE HER MANAGER");
			String contextPath = ((HttpServletRequest) request)
					.getContextPath();
			((HttpServletResponse) response).sendRedirect(contextPath
					+ "/authorization");
		}
		else {
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
