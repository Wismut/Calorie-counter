package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.UserMealServiceImpl;

import java.util.List;

@Controller
public class UserMealRestController {
	private static final LoggerWrapper LOG = LoggerWrapper.get(UserMealRestController.class);

	@Autowired
	private UserMealServiceImpl service;

	public UserMeal get(final int id) {
		final int userId = LoggedUser.id();
		LOG.info("get meal {} for user with id {}", id, userId);
		return service.get(id, userId);
	}

	public void delete(final int id) {
		final int userId = LoggedUser.id();
		LOG.info("delete meal {} for user with id {}", id, userId);
		service.delete(id, userId);
	}

	public List<UserMeal> getAll() {
		final int userId = LoggedUser.id();
		LOG.info("get all meals for user with id {}", userId);
		return service.getAll(userId);
	}

	public void deleteAll() {
		final int userId = LoggedUser.id();
		LOG.info("delete all meals for user with id {}", userId);
		service.deleteAll(userId);
	}
}
