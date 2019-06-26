package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.Date;
import java.util.List;

public interface UserMealRepository {
	// null if not found
	List<UserMeal> getByUserId(String id);

	// null if not found
	UserMeal getByUserMealId(String id);

	List<UserMeal> getFromDateToDate(Date from, Date to);
}
