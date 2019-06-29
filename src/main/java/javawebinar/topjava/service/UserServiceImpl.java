package javawebinar.topjava.service;

import javawebinar.util.exception.ExceptionUtil;
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
		return repository.save(user);
	}

	@Override
	public void delete(int id) throws NotFoundException {
		ExceptionUtil.check(repository.delete(id), id);
	}

	@Override
	public User get(int id) throws NotFoundException {
		return ExceptionUtil.check(repository.get(id), id);
	}

	@Override
	public User getByEmail(String email) throws NotFoundException {
		return ExceptionUtil.check(repository.getByEmail(email), "email=" + email);
	}

	@Override
	public List<User> getAll() {
		return repository.getAll();
	}

	@Override
	public void update(User user) throws NotFoundException {
		ExceptionUtil.check(repository.save(user), user.getId());
	}
}
