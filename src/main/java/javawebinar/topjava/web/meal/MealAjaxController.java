package javawebinar.topjava.web.meal;


import javawebinar.topjava.model.UserMeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ajax/profile/meals")
public class MealAjaxController {
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
	public void update(@RequestParam("id") int id,
	                   @RequestParam("description") String description,
	                   @RequestParam("calories") String calories,
	                   @RequestParam("dateTime") String dateTime) {
		UserMeal userMeal = new UserMeal(id, new Date(dateTime), description, Integer.parseInt(calories));
		if (id == 0) {
			helper.create(userMeal);
		} else {
			helper.update(userMeal, id);
		}
	}
}
