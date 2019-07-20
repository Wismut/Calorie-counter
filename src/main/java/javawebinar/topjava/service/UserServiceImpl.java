package javawebinar.topjava.service;

import javawebinar.topjava.model.User;
import javawebinar.topjava.repository.UserRepository;
import javawebinar.topjava.util.exception.ExceptionUtil;
import javawebinar.topjava.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	@CacheEvict(value = "users", allEntries = true)
	public User save(User user) {
		return repository.save(user);
	}

	@Override
	@CacheEvict(value = "users", allEntries = true)
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
	@Cacheable("users")
	public List<User> getAll() {
		return repository.getAll();
	}

	@Override
	@CacheEvict(value = "users", allEntries = true)
	public void update(User user) throws NotFoundException {
		ExceptionUtil.check(repository.save(user), user.getId());
	}

	@Override
	@CacheEvict(value = "users", allEntries = true)
	public void evictCache() {

	}
}
