package com.clear.dao;

import java.util.List;

import com.clear.entity.User;

public interface UserDao {
	public User getUser(Long id);

	public List<User> getAllUser();

	public void addUser(User user);

	public boolean delUser(String id);

	public boolean updateUser(User user);

}
