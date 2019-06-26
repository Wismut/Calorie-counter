package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.service.UserMealServiceImpl;

@Controller
public class UserMealRestController {

	@Autowired
	private UserMealServiceImpl service;
}
