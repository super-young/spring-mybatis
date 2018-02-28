package com.app.dao;

import java.util.List;

import com.app.domain.AdminUser;

/**
 * 
 * @author young
 *
 */
public interface AdminUserDao {
	/**
	 * get all admin users
	 * @return List<AdminUser>
	 */
	List<AdminUser> getAll();
}
