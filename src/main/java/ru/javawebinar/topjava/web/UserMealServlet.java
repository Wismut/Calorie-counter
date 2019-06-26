package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.LoggerWrapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserMealServlet extends HttpServlet {
	private static final LoggerWrapper LOG = LoggerWrapper.get(UserMealServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("redirect to userMealList");
		resp.sendRedirect("userMealList.jsp");
	}
}