package com.ad.springboot.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlRowSetResultSetExtractor;

import com.ad.springboot.bean.User;
import com.ad.springboot.dao.IUserDao;
import com.ad.springboot.dao.sql.Update;
import com.ad.springboot.dao.sql.Where;
import com.ad.springboot.util.dao.SqlHelper;

public class UserDao implements IUserDao {
	String sqlAdd = "INSERT INTO USER(NAME,AGE,BIRTHDAY,TEL) VALUES(?,?,?,?,?)";
	String sqlDel = "DELETE FROM USER WHERE";
	String sqlEdit = "UPDATE USER SET";
	String sqlGet = "SELECT * FROM USER WHERE NAME=? AND AGE=?/NAME=? OR AGE=?";

	@Autowired
	private JdbcTemplate dao;

	@Override
	public int add(User user) {
		return dao.update(sqlAdd, user.getName(), user.getAge(), user.getBirthday(), user.getTel());
	}

	@Override
	public int delete(Where[] ws) {
		Where[] vps = SqlHelper.getValidParams(ws);
		Object[] values = new Object[vps.length];
		for (int i = 0, c = vps.length; i < c; i++)
			values[i] = vps[i].getV();
		String del = sqlDel + parseWhere(vps);
		return dao.update(del, values);
	}

	@Override
	public int edit(Update[] us, Where[] ws) {

		Update[] uvps = SqlHelper.getValidParams(us);
		Where[] wvps = SqlHelper.getValidParams(ws);

		if (uvps.length == 0 || wvps.length == 0)
			return 0;

		StringBuilder sb = new StringBuilder(sqlEdit);
		sb.append(parseUpdate(uvps));
		sb.append(" WHERE ");
		sb.append(parseWhere(wvps));

		return dao.update(sb.toString(), SqlHelper.getValidValues(uvps), SqlHelper.getValidValues(wvps));
	}

	@Override
	public User getBean(Where[] ws) {
		Where[] wvps = SqlHelper.getValidParams(ws);
		String sql = sqlGet + parseWhere(wvps);
		return (User) dao.query(sql, SqlHelper.getValidValues(wvps), new SqlRowSetResultSetExtractor());
	}

	@Override
	public User[] getList(Where[] ws) {
		Where[] wvps = SqlHelper.getValidParams(ws);
		String sql = sqlGet + parseWhere(wvps);
		List<User> result = dao.queryForList(sql, SqlHelper.getValidValues(wvps), User.class);
		return result.toArray(new User[result.size()]);
	}

	private String parseUpdate(Update[] us) {
		StringBuilder sb = new StringBuilder();
		for (Update u : us)
			sb.append(" " + u.getK().trim().toUpperCase()).append("=").append("?").append(" AND");

		return sb.substring(0, sb.length() - 4);
	}

	private String parseWhere(Where[] ws) {
		StringBuilder sb = new StringBuilder();
		for (Where w : ws)
			sb.append(" " + w.getK().trim().toUpperCase()).append(w.getO()).append("?").append(" AND");
		return sb.substring(0, sb.length() - 4);
	}

}
