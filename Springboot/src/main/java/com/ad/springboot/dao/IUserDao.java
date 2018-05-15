package com.ad.springboot.dao;

import com.ad.springboot.bean.User;

public interface IUserDao {
	User add(User user);

	int delete(int id);

	int edit(int id);
	
	User getBean(int id);
	
	User[] getList();
}
