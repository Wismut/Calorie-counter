package javawebinar.topjava.web.user;

import javawebinar.topjava.LoggerWrapper;
import javawebinar.topjava.model.User;
import javawebinar.topjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/admin/users")
public class AdminUserRestController {
	private static final LoggerWrapper LOG = LoggerWrapper.get(AdminUserRestController.class);

	@Autowired
	private UserService service;

	public List<User> getAll() {
		LOG.info("get all users");
		return service.getAll();
	}

	public User get(final int id) {
		LOG.info("get user by id {}", id);
		return service.get(id);
	}

	public void delete(final int id) {
		LOG.info("delete user by id {}", id);
		service.delete(id);
	}

	public User create(final User user) {
		LOG.info("save user", user);
		return service.save(user);
	}

	public void update(final User user) {
		LOG.info("update user", user);
		service.update(user);
	}

	public User getByEmail(final String email) {
		LOG.info("get user by email {}", email);
		return service.getByEmail(email);
	}
}
