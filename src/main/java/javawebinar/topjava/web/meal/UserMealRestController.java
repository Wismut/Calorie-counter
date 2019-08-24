package javawebinar.topjava.web.meal;


import javawebinar.topjava.model.UserMeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rest/profile/meals")
public class UserMealRestController {
	@Autowired
	private UserMealHelper helper;

	public static final String REST_URL = "/rest/profile/meals";

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserMeal get(@PathVariable("id") int id) {
		return helper.get(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		helper.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserMeal> getAll() {
		return helper.getAll();
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteAll() {
		helper.deleteAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody UserMeal meal, @PathVariable("id") int id) {
		helper.update(meal, id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserMeal> create(@RequestBody UserMeal meal) {
		UserMeal userMeal = helper.create(meal);
		URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/rest/profile/meals/{id}")
				.buildAndExpand(userMeal.getId()).toUri();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(uriOfNewResource);
		return new ResponseEntity<>(userMeal, httpHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/between", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserMeal> getBetween(@RequestParam(value = "startDate") Date startDate,
	                                 @RequestParam(value = "endDate") Date endDate) {
		return helper.getBetween(startDate, endDate);
	}
}
