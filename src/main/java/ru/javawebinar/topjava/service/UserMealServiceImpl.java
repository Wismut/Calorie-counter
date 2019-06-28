package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserMealServiceImpl implements UserMealService {

	@Autowired
	private UserMealRepository repository;

	public UserMeal get(final int id, final int userId) {
		return repository.get(id, userId);
	}

	public void delete(final int id, final int userId) {
		repository.delete(id, userId);
	}

	public List<UserMeal> getAll(final int userId) {
		return repository.getAll(userId);
	}

	public void deleteAll(final int userId) {
		repository.deleteAll(userId);
	}

	public void update(final UserMeal meal, final int userId) {
		repository.update(meal, userId);
	}

	public void save(final UserMeal meal, final int userId) {
		repository.create(meal, userId);
	}

	public List<UserMeal> getBetween(final LocalDateTime startDate, final LocalDateTime endDate, final int userId) {
		return repository.getBetween(startDate, endDate, userId);
	}
}
