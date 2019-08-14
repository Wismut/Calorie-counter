package javawebinar.topjava.web;

import javawebinar.topjava.LoggerWrapper;
import javawebinar.topjava.model.User;
import javawebinar.topjava.model.UserMeal;
import javawebinar.topjava.service.UserMealService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class UserMealServlet extends HttpServlet {
	private static final LoggerWrapper LOG = LoggerWrapper.get(UserMealServlet.class);
	private WebApplicationContext webApplicationContext;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("redirect to userMealList");
		UserMealService userMealService = webApplicationContext.getBean(UserMealService.class);
		List<UserMeal> userMeals = userMealService.getAll(User.START_SEQ);
		req.setAttribute("userMeals", userMeals);
		req.getRequestDispatcher("/mealList.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
