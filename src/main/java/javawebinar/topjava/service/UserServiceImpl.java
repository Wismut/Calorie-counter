package javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javawebinar.topjava.model.User;
import javawebinar.topjava.repository.UserRepository;
import javawebinar.util.exception.NotFoundException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User save(User user) {
		return null;
	}

	@Override
	public void delete(int id) throws NotFoundException {

	}

	@Override
	public User get(int id) throws NotFoundException {
		return null;
	}

	@Override
	public User getByEmail(String email) throws NotFoundException {
		return null;
	}

	@Override
	public List<User> getAll() {
		return null;
	}

	@Override
	public void update(User user) throws NotFoundException {

	}
}
