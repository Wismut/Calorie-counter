package javawebinar.topjava.repository.jdbc;


import javawebinar.topjava.model.UserMeal;
import javawebinar.topjava.repository.UserMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;


@Repository
public class JdbcUserMealRepositoryImpl implements UserMealRepository {

	private static final RowMapper<UserMeal> ROW_MAPPER =
			(rs, rowNum) -> new UserMeal(rs.getInt("id"), rs.getTimestamp("dateTime"), rs.getString("description"), rs.getInt("calories"));

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private SimpleJdbcInsert insertUserMeal;

	@Autowired
	public JdbcUserMealRepositoryImpl(DataSource dataSource) {
		this.insertUserMeal = new SimpleJdbcInsert(dataSource)
				.withTableName("MEALS")
				.usingGeneratedKeyColumns("id");
	}

	@Override
	public UserMeal save(UserMeal userMeal, int userId) {
		MapSqlParameterSource map = new MapSqlParameterSource()
				.addValue("id", userMeal.getId())
				.addValue("description", userMeal.getDescription())
				.addValue("calories", userMeal.getCalories())
//				.addValue("datetime", Timestamp.valueOf(userMeal.getDateTime()))
				.addValue("datetime", userMeal.getDateTime())
				.addValue("user_id", userId);
		if (userMeal.isNew()) {
			Number newId = insertUserMeal.executeAndReturnKey(map);
			userMeal.setId(newId.intValue());
		} else {
			if (namedParameterJdbcTemplate.update(
					"UPDATE meals SET description=:description, calories=:calories, datetime=:datetime " +
							" WHERE id=:id AND user_id=:user_id", map) == 0) {
				return null;
			}
		}
		return userMeal;
	}

	@Override
	public List<UserMeal> getByUserId(String id) {
		return jdbcTemplate.query("SELECT * FROM meals WHERE user_id = ?", ROW_MAPPER, id);
	}

	@Override
	public UserMeal getByUserMealId(String id) {
		final List<UserMeal> userMeals = jdbcTemplate.query("SELECT * FROM meals WHERE id = ?", ROW_MAPPER, id);
		return CollectionUtils.isEmpty(userMeals) ? null : DataAccessUtils.requiredSingleResult(userMeals);
	}

	@Override
	public boolean delete(int id, int userId) {
		return jdbcTemplate.update("DELETE FROM meals WHERE id=? AND user_id=?", id, userId) != 0;
	}

	@Override
	public void deleteAll(int userId) {
		jdbcTemplate.update("DELETE FROM meals WHERE user_id=?", userId);
	}

	@Override
	public UserMeal update(UserMeal meal, int userId) {
		MapSqlParameterSource map = new MapSqlParameterSource()
				.addValue("id", meal.getId())
				.addValue("description", meal.getDescription())
				.addValue("calories", meal.getCalories())
//				.addValue("datetime", Timestamp.valueOf(meal.getDateTime()))
				.addValue("datetime", meal.getDateTime())
				.addValue("user_id", userId);
		namedParameterJdbcTemplate.update("UPDATE meals SET datetime=:datetime, description=:description, calories=:calories WHERE user_id=:user_id AND id=:id", map);
		return meal;
//		return jdbcTemplate.update("UPDATE meals SET datetime = ?, description = ?, calories = ? WHERE user_id = ?", ROW_MAPPER, meal.getDateTime(), meal.getDescription(), meal.getCalories(), userId);
	}

	@Override
	public UserMeal get(int id, int userId) {
		List<UserMeal> userMeals = jdbcTemplate.query(
				"SELECT * FROM meals WHERE id = ? AND user_id = ?", ROW_MAPPER, id, userId);
		return CollectionUtils.isEmpty(userMeals) ? null : DataAccessUtils.requiredSingleResult(userMeals);
	}

	@Override
	public List<UserMeal> getAll(int userId) {
		return jdbcTemplate.query(
				"SELECT * FROM meals WHERE user_id=? ORDER BY dateTime DESC", ROW_MAPPER, userId);
	}

	@Override
	public List<UserMeal> getBetween(Date startDate, Date endDate, int userId) {
		return jdbcTemplate.query(
				"SELECT * FROM meals WHERE dateTime >= ? AND dateTime < ? AND user_id = ? ORDER BY dateTime DESC",
				ROW_MAPPER,startDate, endDate, userId);
	}
}
