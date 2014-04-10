package com.clear.service;

import java.util.List;



import com.clear.entity.User;

public interface UserService {
	public User getUser(Long id);
	
	public List<User> getAllUser();

	public void addUser(User user);

	public boolean delUser(String id);

	public boolean updateUser(User user);

}