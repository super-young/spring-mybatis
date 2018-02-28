package com.app.service;

import java.util.List;

import com.app.domain.AdminUser;

/**
 * 
 * @author young
 *
 */
public interface AdminUserService {
	/**
	 * get all admin users
	 * @return List<AdminUser>
	 */
	List<AdminUser> getUsers();
}
