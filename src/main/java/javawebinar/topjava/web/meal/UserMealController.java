package javawebinar.topjava.web.meal;

import javawebinar.topjava.LoggedUser;
import javawebinar.topjava.service.UserMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserMealController {
	@Autowired
	private UserMealService service;

	@RequestMapping(value = "/meals", method = RequestMethod.GET)
	public String mealList(final Model model) {
		model.addAttribute("mealList", service.getAll(LoggedUser.id()));
		return "mealList";
	}
}
