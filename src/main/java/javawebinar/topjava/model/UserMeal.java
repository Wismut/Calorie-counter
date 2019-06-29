package javawebinar.topjava.model;

import javawebinar.util.TimeUtil;

import java.time.LocalDateTime;

public class UserMeal extends BaseEntity {
	private LocalDateTime dateTime;
	private String description;
	private int calories;

	private User user;

	public UserMeal() {

	}

	public UserMeal(final Integer id, final LocalDateTime dateTime, final String description, final int calories) {
		super(id);
		this.dateTime = dateTime;
		this.description = description;
		this.calories = calories;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCalories() {
		return calories;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserMeal{" +
				"dateTime=" + TimeUtil.toString(dateTime) +
				", description='" + description + '\'' +
				", calories=" + calories +
				", id=" + id +
				'}';
	}
}
