package javawebinar.topjava.web.meal;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserMealController {
	@RequestMapping(value = "/meals", method = RequestMethod.GET)
	public String mealList() {
		return "mealList";
	}
}
