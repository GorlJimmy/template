package org.linuxkernel.template.cv.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.linuxkernel.template.cv.util.SessionUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
public class LoginFilter extends GenericFilterBean {

	private String[] allows = new String[1];

	public LoginFilter() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
//
//		if (requiresAuthentication((HttpServletRequest) request)) {
//			String requestType = ((HttpServletRequest) request).getHeader("X-Requested-With");
//			if (requestType != null && !requestType.isEmpty() && requestType.equalsIgnoreCase("XMLHttpRequest")) {
//				((HttpServletResponse) response).setStatus(404);
//				((HttpServletResponse) response).setHeader("sessionstatus", "timeout");
//				return;
//			}
//
//			//((HttpServletResponse) response).sendRedirect(Config.LOGINURL);
//			return;
//		}

		chain.doFilter(request, response);
	}

	private boolean requiresAuthentication(HttpServletRequest request) {
		for (int i = 0; i < allows.length; i++) {
			if (request.getServletPath().contains(allows[i])) {
				return false;
			}
		}
		Object service = SessionUtil.getVolumeService(request.getSession());
		if (service == null) {
			return true;
		}
		return false;
	}

	public String[] getAllows() {
		return allows;
	}

	public void setAllows(String[] allows) {
		this.allows = allows;
	}

}