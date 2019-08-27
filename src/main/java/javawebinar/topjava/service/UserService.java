package javawebinar.topjava.service;

import javawebinar.topjava.model.User;
import javawebinar.topjava.to.UserTo;
import javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

public interface UserService {
	User save(User user);

	void delete(int id) throws NotFoundException;

	User get(int id) throws NotFoundException;

	User getByEmail(String email) throws NotFoundException;

	List<User> getAll();

	void update(User user) throws NotFoundException;

	void update(UserTo user) throws NotFoundException;

	void evictCache();
}
