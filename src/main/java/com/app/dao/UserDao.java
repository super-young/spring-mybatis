package com.app.dao;

import com.app.domain.User;

public interface UserDao {
	public User selectUserById(Integer id);
}
