package javawebinar.topjava.model;

import javawebinar.topjava.matcher.ModelMatcher;

public class UserMealTestData {
	public static final ModelMatcher<UserMeal, TestUserMeal> MATCHER = new ModelMatcher<>(
			u -> ((u instanceof TestUserMeal) ? (TestUserMeal) u : new TestUserMeal(u)), UserMeal.class);
}
