package javawebinar.topjava.repository.jpa;

import javawebinar.topjava.model.User;
import javawebinar.topjava.model.UserMeal;
import javawebinar.topjava.repository.UserMealRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;


@Repository
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class JpaUserMealRepositoryImpl implements UserMealRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public UserMeal save(UserMeal userMeal, int userId) {
		User user = em.getReference(User.class, userId);
		userMeal.setUser(user);
		if (userMeal.isNew()) {
			em.persist(userMeal);
		} else {
			if (get(userMeal.getId(), userId) == null) {
				return null;
			}
			em.merge(userMeal);
		}
		return userMeal;
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
		return em.createNamedQuery(UserMeal.DELETE)
				.setParameter("id", id)
				.setParameter("userId", userId)
				.executeUpdate() != 0;
	}

	@Override
	public List<UserMeal> getAll(int userId) {
		return em.createNamedQuery(UserMeal.ALL_SORTED, UserMeal.class)
				.setParameter("userId", userId)
				.getResultList();
	}

	@Override
	@Transactional
	public void deleteAll(int userId) {
		em.createNamedQuery(UserMeal.DELETE_ALL)
				.setParameter("userId", userId)
				.executeUpdate();
	}

	@Override
	@Transactional
	public UserMeal update(UserMeal meal, int userId) {
		User user = em.getReference(User.class, userId);
		meal.setUser(user);
		if (meal.isNew()) {
			em.persist(meal);
		} else {
			if (get(meal.getId(), userId) == null) {
				return null;
			}
			em.merge(meal);
		}
		return meal;
	}

	@Override
	public List<UserMeal> getBetween(Date startDate, Date endDate, int userId) {
		return em.createNamedQuery(UserMeal.GET_BETWEEN, UserMeal.class)
				.setParameter("userId", userId)
				.setParameter("after", startDate)
				.setParameter("before", endDate).getResultList();
	}
}
