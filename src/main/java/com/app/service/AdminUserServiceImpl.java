package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.AdminUserDao;
import com.app.domain.AdminUser;

/**
 * 
 * @author young
 *
 */
@Component
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private AdminUserDao dao;
	@Override
	public List<AdminUser> getUsers() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

}
