package javawebinar.topjava.web.user;

import javawebinar.topjava.LoggerWrapper;
import javawebinar.topjava.model.User;
import javawebinar.topjava.service.UserService;
import javawebinar.topjava.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserHelper {
	private static final LoggerWrapper LOG = LoggerWrapper.get(UserHelper.class);

	@Autowired
	private UserService service;

	public List<User> getAll() {
		LOG.info("get all");
		List<User> all = service.getAll();
		all.forEach(u -> u.setPassword(null));
		return all;
	}

	public User get(int id) {
		LOG.info("get " + id);
		User user = service.get(id);
		user.setPassword(null);
		return user;
	}

	public User create(User user) {
		LOG.info("create " + user);
		return service.save(PasswordUtil.getEncoded(user));
	}

	public void delete(int id) {
		LOG.info("delete " + id);
		service.delete(id);
	}

	public void update(User user) {
		LOG.info("update " + user);
		service.update(PasswordUtil.getEncoded(user));
	}

	public User getByEmail(final String email) {
		LOG.info("getByEmail " + email);
		return service.getByEmail(email);
	}

	public void update(User user, int id) {
		LOG.info("update " + user);
		user.setId(id);
		service.update(user);
	}
}
