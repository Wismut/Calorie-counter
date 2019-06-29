package javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import javawebinar.topjava.LoggerWrapper;
import javawebinar.topjava.model.User;
import javawebinar.topjava.repository.UserRepository;

import java.util.List;

@Repository
public class MockUserRepository implements UserRepository {
	private static final LoggerWrapper LOG = LoggerWrapper.get(MockUserRepository.class);

	@Override
	public User save(User user) {
		LOG.info("Save " + user);
		return user;
	}

	@Override
	public boolean delete(int id) {
		LOG.info("Delete " + id);
		return true;
	}

	@Override
	public User get(int id) {
		return null;
	}

	@Override
	public User getByEmail(String email) {
		return null;
	}

	@Override
	public List<User> getAll() {
		return null;
	}
}
