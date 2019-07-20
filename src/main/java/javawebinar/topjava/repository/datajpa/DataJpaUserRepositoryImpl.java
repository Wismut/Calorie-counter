package javawebinar.topjava.repository.datajpa;

import javawebinar.topjava.model.User;
import javawebinar.topjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DataJpaUserRepositoryImpl implements UserRepository {
	@Autowired
	private ProxyUserRepository proxy;

	@Override
	public User save(User user) {
		return null;
	}

	@Override
	public boolean delete(int id) {
		return proxy.delete(id) != 0;
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
