package javawebinar.topjava.repository.jpa;

import javawebinar.topjava.model.UserMeal;
import javawebinar.topjava.repository.UserMealRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class JpaUserMealRepositoryImpl implements UserMealRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
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
		List<UserMeal> userMeals = em.createNamedQuery(UserMeal.GET, UserMeal.class)
				.setParameter("id", id)
				.setParameter("userId", userId)
				.getResultList();
		return userMeals.size() == 0 ? null : DataAccessUtils.requiredSingleResult(userMeals);
	}

	@Override
	@Transactional
	public boolean delete(int id, int userId) {
		return false;
	}

	@Override
	public List<UserMeal> getAll(int userId) {
		return null;
	}

	@Override
	@Transactional
	public void deleteAll(int userId) {

	}

	@Override
	@Transactional
	public UserMeal update(UserMeal meal, int userId) {
		return null;
	}

	@Override
	@Transactional
	public UserMeal create(UserMeal meal, int userId) {
		return null;
	}

	@Override
	public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
		return em.createNamedQuery(UserMeal.GET_BETWEEN, UserMeal.class)
				.setParameter("userId", userId)
				.setParameter("after", startDate)
				.setParameter("before", endDate).getResultList();
	}
}
