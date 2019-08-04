package javawebinar.topjava.web.meal;

import javawebinar.topjava.LoggedUser;
import javawebinar.topjava.LoggerWrapper;
import javawebinar.topjava.model.UserMeal;
import javawebinar.topjava.service.UserMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class UserMealHelper {
	private static final LoggerWrapper LOG = LoggerWrapper.get(UserMealHelper.class);

	@Autowired
	private UserMealService service;

	public List<UserMeal> getAll() {
		LOG.info("get all");
		return service.getAll(LoggedUser.id());
	}

	public UserMeal get(int id) {
		LOG.info("get " + id);
		return service.get(id, LoggedUser.id());
	}

	public UserMeal create(UserMeal meal) {
		LOG.info("create " + meal);
		return service.save(meal, LoggedUser.id());
	}

	public void delete(int id) {
		LOG.info("delete " + id);
		service.delete(id, LoggedUser.id());
	}

	public void update(UserMeal meal, int id) {
		LOG.info("update " + meal);
		service.update(meal, id);
	}

	public List<UserMeal> getBetween(Date startDate, Date endDate) {
		LOG.info("get from " + startDate + " to " + endDate);
		return service.getBetween(startDate, endDate, LoggedUser.id());
	}

	public void deleteAll() {
		LOG.info("deleteAll");
		service.deleteAll(LoggedUser.id());
	}
}
