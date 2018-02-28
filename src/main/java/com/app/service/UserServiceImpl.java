package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.domain.User;

/**
 * 
 * @author young
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;
	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return dao.selectUserById(id);
	}
	@Override
	public Integer add(User user) {
		// TODO Auto-generated method stub
		return dao.addUser(user);
	}

}
