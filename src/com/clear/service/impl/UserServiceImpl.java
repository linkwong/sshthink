package com.clear.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.clear.dao.UserDao;
import com.clear.entity.User;
import com.clear.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	public void addUser(User user) {
		userDao.addUser(user);
	}

	public boolean delUser(String id) {
		return userDao.delUser(id);
	}

	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	public User getUser(Long id) {
		return userDao.getUser(id);
	}
}
