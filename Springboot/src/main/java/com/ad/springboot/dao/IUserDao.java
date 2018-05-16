package com.ad.springboot.dao;

import com.ad.springboot.bean.User;
import com.ad.springboot.dao.sql.Update;
import com.ad.springboot.dao.sql.Where;

public interface IUserDao {

	int add(User user) throws Exception;

	int delete(Where[] ws) throws Exception;

	int edit(Update[] us, Where[] ws) throws Exception;

	User getBean(Where[] ws) throws Exception;

	User[] getList(Where[] ws) throws Exception;
}
