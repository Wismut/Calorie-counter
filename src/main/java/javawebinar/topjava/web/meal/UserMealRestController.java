package javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javawebinar.topjava.LoggedUser;
import javawebinar.topjava.LoggerWrapper;
import javawebinar.topjava.model.UserMeal;
import javawebinar.topjava.service.UserMealService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class UserMealRestController {
	private static final LoggerWrapper LOG = LoggerWrapper.get(UserMealRestController.class);

	@Autowired
	private UserMealService service;

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

	public void update(final UserMeal meal) {
		final int userId = LoggedUser.id();
		LOG.info("update meal {} for user with id {}", meal, userId);
		service.update(meal, userId);
	}

	public void create(final UserMeal meal) {
		final int userId = LoggedUser.id();
		LOG.info("save meal {} for user with id {}", meal, userId);
		service.save(meal, userId);
	}

	public List<UserMeal> getBetween(final LocalDateTime startDate, final LocalDateTime endDate) {
		final int userId = LoggedUser.id();
		LOG.info("getBetween meals from {} to for user with id {}", startDate, endDate, userId);
		return service.getBetween(startDate, endDate, userId);
	}
}
