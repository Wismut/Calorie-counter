package javawebinar.topjava.repository.datajpa;

import javawebinar.topjava.model.UserMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface ProxyUserMealRepository extends JpaRepository<UserMeal, Integer> {
	@Query("SELECT m FROM UserMeal m WHERE m.id = ?1 AND m.user.id = ?2")
	UserMeal get(int id, int userId);

	@Transactional
	@Modifying
	@Query("DELETE FROM UserMeal m WHERE m.id = ?1 AND m.user.id = ?2")
	int delete(int id, int userId);

	@Override
	UserMeal save(UserMeal meal);

	@Query("SELECT m FROM UserMeal m WHERE m.dateTime > ?1 AND m.dateTime < ?2 AND m.user.id = ?3")
	List<UserMeal> getBetween(Date startDate, Date endDate, int userId);

	@Query("SELECT m FROM UserMeal m WHERE m.user.id = ?1 ORDER BY m.dateTime DESC")
	List<UserMeal> getAll(int userId);
}
