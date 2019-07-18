package javawebinar.topjava.model;

public class TestUserMeal extends UserMeal {
	public TestUserMeal(final UserMeal meal) {
		super(meal.getId(), meal.getDateTime(), meal.getDescription(), meal.getCalories());
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}

	@Override
	public String toString() {
		return "TestUserMeal{" +
				"id=" + id +
				'}';
	}
}
