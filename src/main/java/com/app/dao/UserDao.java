package com.app.dao;

import com.app.domain.User;

/**
 * 
 * @author young
 *
 */
public interface UserDao {
	/**
	 * get user by id
	 * @param id
	 * @return User
	 */
	public User selectUserById(Integer id);
	
	/**
	 * add a user
	 * @param user
	 * @return Integer
	 */
	public Integer addUser(User user);
}
