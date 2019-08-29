package javawebinar.topjava.web.meal;


import javawebinar.topjava.LoggedUser;
import javawebinar.topjava.model.UserMeal;
import javawebinar.topjava.to.DateTimeFilter;
import javawebinar.topjava.to.UserMealWithExceed;
import javawebinar.topjava.util.TimeUtil;
import javawebinar.topjava.web.ExceptionInfoHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ajax/profile/meals")
public class MealAjaxController extends ExceptionInfoHandler {
	@Autowired
	private UserMealHelper helper;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserMeal> getAll() {
		return helper.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserMeal get(@PathVariable("id") int id) {
		return helper.get(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		helper.delete(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> update(@Valid UserMeal meal, BindingResult result) {
		if (result.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			result.getFieldErrors().forEach(fe -> sb.append(fe.getField()).append(" ").append(fe.getField()));
			return new ResponseEntity<>(sb.toString(), HttpStatus.UNPROCESSABLE_ENTITY);
		} else {
			if (meal.getId() == 0) {
				meal.setId(null);
				helper.create(meal);
			} else {
				helper.update(meal, meal.getId());
			}
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/filter", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserMealWithExceed> filterWithExceed(DateTimeFilter filter) {
		return null;
//		return filterWithExceed(super.getBetween(startDateTime(filter.getStartDate()), endDateTime(filter.getEndDate())),
//				toTime(filter.getStartTime(), LocalTime.MIN), toTime(filter.getEndTime(), LocalTime.MAX));
	}

	public List<UserMealWithExceed> filterWithExceed(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime) {
		int caloriesPerDay = LoggedUser.get().getUserTo().getCaloriesPerDay();
		Map<Date, Integer> groupAndSumMap = mealList.stream().collect(Collectors.groupingBy(
				UserMeal::getDateTime,
				Collectors.summingInt(UserMeal::getCalories)
		));
		return mealList.stream()
				.filter(meal -> TimeUtil.isBetween(LocalDateTime.ofInstant(meal.getDateTime().toInstant(), ZoneId.systemDefault()).toLocalTime(), startTime, endTime))
				.map(meal -> new UserMealWithExceed(meal.getId(), LocalDateTime.ofInstant(meal.getDateTime().toInstant(), ZoneId.systemDefault()), meal.getDescription(),
						meal.getCalories(), groupAndSumMap.get(meal.getDateTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()) > caloriesPerDay))
				.collect(Collectors.toList());
	}
}
