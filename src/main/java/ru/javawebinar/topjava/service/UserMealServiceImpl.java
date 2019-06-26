package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import java.util.List;

@Service
public class UserMealServiceImpl {

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
}
