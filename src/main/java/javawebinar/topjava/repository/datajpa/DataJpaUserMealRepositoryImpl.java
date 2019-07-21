package javawebinar.topjava.repository.datajpa;

import javawebinar.topjava.model.User;
import javawebinar.topjava.model.UserMeal;
import javawebinar.topjava.repository.UserMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public class DataJpaUserMealRepositoryImpl implements UserMealRepository {
	@Autowired
	private ProxyUserMealRepository proxyUserMealRepository;

	@Autowired
	private ProxyUserRepository proxyUserRepository;

	@Override
	public UserMeal get(int id, int userId) {
		return proxyUserMealRepository.get(id, userId);
	}

	@Override
	public boolean delete(int id, int userId) {
		return proxyUserMealRepository.delete(id, userId) != 0;
	}

	@Override
	public List<UserMeal> getAll(int userId) {
		return proxyUserMealRepository.getAll(userId);
	}

	@Override
	public void deleteAll(int userId) {
		proxyUserMealRepository.deleteAll();
	}

	@Override
	public UserMeal update(UserMeal meal, int userId) {
		meal.setUser(proxyUserRepository.getOne(userId));
		if (!meal.isNew() && get(meal.getId(), userId) == null) {
			return null;
		}
		return proxyUserMealRepository.save(meal);
	}

	@Override
	public UserMeal save(UserMeal meal, int userId) {
		User user = proxyUserRepository.findOne(userId);
		meal.setUser(user);
		return proxyUserMealRepository.save(meal);
	}

	@Override
	public List<UserMeal> getBetween(Date startDate, Date endDate, int userId) {
		return proxyUserMealRepository.getBetween(startDate, endDate, userId);
	}
}
