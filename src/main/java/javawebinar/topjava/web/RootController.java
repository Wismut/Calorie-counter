package javawebinar.topjava.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RootController {
	@RequestMapping(value = "/meals", method = RequestMethod.GET)
	public String mealList() {
		return "mealList";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String userList() {
		return "userList";
	}
}
