package javawebinar.topjava.service;

import javawebinar.topjava.model.User;
import javawebinar.topjava.model.UserMeal;
import javawebinar.topjava.repository.UserMealRepository;
import javawebinar.topjava.util.exception.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserMealServiceImpl implements UserMealService {

	@Autowired
	private UserMealRepository repository;

	@Autowired
	private UserService userService;

	public UserMeal get(final int id, final int userId) {
		final User user = userService.get(userId);
		final UserMeal userMeal = ExceptionUtil.check(repository.get(id, userId), id);
		if (userMeal != null) {
			userMeal.setUser(user);
		}
		return userMeal;
	}

	public void delete(final int id, final int userId) {
		ExceptionUtil.check(repository.delete(id, userId), id);
	}

	public List<UserMeal> getAll(final int userId) {
		return repository.getAll(userId);
	}

	public void deleteAll(final int userId) {
		repository.deleteAll(userId);
	}

	public UserMeal update(final UserMeal meal, final int userId) {
		return ExceptionUtil.check(repository.update(meal, userId), meal.getId());
	}

	public UserMeal save(final UserMeal meal, final int userId) {
		return repository.save(meal, userId);
	}

	public List<UserMeal> getBetween(final Date startDate, final Date endDate, final int userId) {
		return repository.getBetween(startDate, endDate, userId);
	}
}
