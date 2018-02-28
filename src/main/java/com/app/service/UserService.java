package com.app.service;

import com.app.domain.User;

/**
 * 
 * @author young
 *
 */
public interface UserService {
	/**
	 * get user by id
	 * @param id
	 * @return User
	 */
	User getById(int id);
	
	/**
	 * add a  user
	 * @param user
	 * @return Integer
	 */
	Integer add(User user);
}
