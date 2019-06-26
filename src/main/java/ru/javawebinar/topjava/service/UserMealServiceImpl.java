package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.repository.UserMealRepository;

@Service
public class UserMealServiceImpl {

//	@Autowired
	private UserMealRepository repository;
}
