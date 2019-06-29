package javawebinar.topjava.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javawebinar.topjava.LoggedUser;
import javawebinar.topjava.LoggerWrapper;
import javawebinar.topjava.model.User;
import javawebinar.topjava.service.UserService;

@Controller
public class UserRestController {
	private static final LoggerWrapper LOG = LoggerWrapper.get(UserRestController.class);

	@Autowired
	private UserService service;

	public User get() {
		final int userId = LoggedUser.id();
		LOG.info("get user by id {}", userId);
		return service.get(userId);
	}

	public void delete() {
		final int userId = LoggedUser.id();
		LOG.info("delete user by id {}", userId);
		service.delete(userId);
	}

	public void update(final User user) {
		LOG.info("update user");
		service.update(user);
	}
}
