package javawebinar.topjava.web.meal;


import javawebinar.topjava.model.UserMeal;
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
import java.util.List;

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
}
