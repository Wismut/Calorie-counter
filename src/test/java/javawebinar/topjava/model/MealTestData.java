package javawebinar.topjava.model;

import javawebinar.topjava.matcher.ModelMatcher;
import javawebinar.topjava.util.TestUtil.ToStringModelMatcher;

import java.util.Calendar;
import java.util.Date;


public class MealTestData {
    public static final int MEAL1_ID = BaseEntity.START_SEQ + 2;

    public static final UserMeal MEAL1 = new UserMeal(MEAL1_ID, new Date(2015, Calendar.JANUARY, 6, 9, 0), "breakfast", 500);
    public static final UserMeal MEAL2 = new UserMeal(MEAL1_ID + 1, new Date(2015, Calendar.JANUARY, 6, 13, 0), "dinner", 1000);
    public static final UserMeal MEAL3 = new UserMeal(MEAL1_ID + 2, new Date(2015, Calendar.JANUARY, 7, 0, 0), "supper", 600);
    public static final UserMeal MEAL4 = new UserMeal(MEAL1_ID + 3, new Date(2015, Calendar.JANUARY, 7, 13, 0), "dinner", 1300);
    public static final UserMeal ADMIN_MEAL = new UserMeal(MEAL1_ID + 4, new Date(2015, Calendar.JANUARY, 6, 14, 0), "admin_meal", 2000);

    public static UserMeal getCreated() {
        return new UserMeal(null, new Date(2015, Calendar.JANUARY, 8, 18, 0), "created", 300);
    }

    public static UserMeal getUpdated() {
        UserMeal updated = new UserMeal(MEAL1);
        updated.setDescription("Updated breakfast");
        return updated;
    }

    public static final ModelMatcher<UserMeal, String> MATCHER = new ToStringModelMatcher<>(UserMeal.class);
}
