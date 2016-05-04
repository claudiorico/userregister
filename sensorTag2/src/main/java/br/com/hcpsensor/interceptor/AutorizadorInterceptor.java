package br.com.hcpsensor.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {

		String user = request.getRemoteUser();
		if (user != null) {
			request.getSession().setAttribute("usuarioLogado", user);
			return true;
		}

		if (request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}
		response.sendRedirect("menu");
		return false;
	}

}
