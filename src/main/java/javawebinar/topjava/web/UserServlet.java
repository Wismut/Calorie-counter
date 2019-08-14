package javawebinar.topjava.web;

import javawebinar.topjava.LoggerWrapper;
import javawebinar.topjava.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
	private static final LoggerWrapper LOG = LoggerWrapper.get(UserServlet.class);
	private WebApplicationContext wac;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("redirect to userList");
		UserService userService = wac.getBean(UserService.class);
		req.setAttribute("userList", userService.getAll());
		req.getRequestDispatcher("/userList.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
