package ru.javawebinar.topjava.model;

import java.util.Date;

public class UserMeal extends BaseEntity {
	private Date timeOfCreating;
	private String description;
	private int calories;

	public UserMeal() {

	}

	public UserMeal(Date timeOfCreating, String description, int calories) {
		this.timeOfCreating = timeOfCreating;
		this.description = description;
		this.calories = calories;
	}

	public Date getTimeOfCreating() {
		return timeOfCreating;
	}

	public void setTimeOfCreating(Date timeOfCreating) {
		this.timeOfCreating = timeOfCreating;
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

	public void setCalories(int calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "UserMeal{" +
				"timeOfCreating=" + timeOfCreating +
				", description='" + description + '\'' +
				", calories=" + calories +
				", id=" + id +
				'}';
	}
}
