package javawebinar.topjava.repository.datajpa;

import javawebinar.topjava.model.UserMeal;
import javawebinar.topjava.repository.UserMealRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public class DataJpaUserMealRepositoryImpl implements UserMealRepository {

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
	public UserMeal save(UserMeal meal, int userId) {
		return null;
	}

	@Override
	public List<UserMeal> getBetween(Date startDate, Date endDate, int userId) {
		return null;
	}
}
