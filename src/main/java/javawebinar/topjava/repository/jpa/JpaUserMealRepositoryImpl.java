package javawebinar.topjava.repository.jpa;

import javawebinar.topjava.model.UserMeal;
import javawebinar.topjava.repository.UserMealRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public class JpaUserMealRepositoryImpl implements UserMealRepository {
	@Override
	public UserMeal save(UserMeal userMeal, int userId) {
		return null;
	}

	@Override
	public List<UserMeal> getByUserId(String id) {
		return null;
	}

	@Override
	public UserMeal getByUserMealId(String id) {
		return null;
	}

	@Override
	public UserMeal get(int id, int userId) {
		return null;
	}

	@Override
	public boolean delete(int id, int userId) {
		return false;
	}

	@Override
	public List<UserMeal> getAll(int userId) {
		return null;
	}

	@Override
	public void deleteAll(int userId) {

	}

	@Override
	public UserMeal update(UserMeal meal, int userId) {
		return null;
	}

	@Override
	public UserMeal create(UserMeal meal, int userId) {
		return null;
	}

	@Override
	public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
		return null;
	}
}
