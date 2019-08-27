package javawebinar.topjava.web;


import javawebinar.topjava.LoggedUser;
import javawebinar.topjava.service.UserService;
import javawebinar.topjava.to.UserTo;
import javawebinar.topjava.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class RootController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String root() {
		return "redirect:meals";
	}

	@RequestMapping(value = "/meals", method = RequestMethod.GET)
	public String mealList() {
		return "mealList";
	}

	//	@Secured("ROLE_ADMIN")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String userList() {
		return "userList";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model,
	                    @RequestParam(value = "error", required = false) boolean error,
	                    @RequestParam(value = "message", required = false) String message) {
		model.put("error", error);
		model.put("message", message);
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(ModelMap model) {
		model.addAttribute("userTo", new UserTo());
		model.addAttribute("register", true);
		return "profile";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveRegister(@Valid UserTo userTo, BindingResult result, SessionStatus status, ModelMap model) {
		if (!result.hasErrors()) {
			try {
				userService.save(UserUtil.createFromTo(userTo));
				status.setComplete();
				return "redirect:login?message=app.registered";
			} catch (DataIntegrityViolationException ex) {
				result.rejectValue("email", "error.user", "User with this email already present in application.");
			}
		}
		model.addAttribute("register", true);
		return "profile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String updateProfile(@Valid UserTo userTo, BindingResult result, SessionStatus status, ModelMap model) {
		if (result.hasErrors()) {
			return "profile";
		} else {
			status.setComplete();
			LoggedUser.get().updateUserTo(userTo);
			userService.update(userTo);
			return "redirect:meals";
		}
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(ModelMap model) {
		return "profile";
	}
}
