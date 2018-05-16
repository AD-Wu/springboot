package com.ad.springboot.util.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.ad.springboot.dao.sql.Update;

public class SqlHelper {

	private SqlHelper() {
	}

	@SuppressWarnings("unchecked")
	public static <T extends Update> T[] getValidParams(T[] ts) {
		List<T> result = new ArrayList<>(ts.length);
		for (T t : ts) {
			if (t.isValid())
				result.add(t);
		}
		return (T[]) result.toArray(new Object[result.size()]);
	}

	public static <T extends Update> Object[] getValidValues(T[] ts) {
		Object[] result = new Object[ts.length];
		for (int i = 0, c = ts.length; i < c; i++)
			result[i] = ts[i].getV();
		return result;

	}

	public static <T> String getAddSql(T t) throws Exception {
		String sqlAdd = "INSERT INTO USER(NAME,AGE,BIRTHDAY,TEL) VALUES(?,?,?,?,?)";
		Class<?> cls = t.getClass();
		String tableName = cls.getSimpleName().toUpperCase().trim();
		StringBuilder sb = new StringBuilder("INSERT INTO ").append(tableName).append("(");
		Field[] fs = cls.getFields();
		AtomicInteger count = new AtomicInteger(fs.length);

		if (fs.length == 0)
			return "";
		for (Field f : fs) {
			sb.append(f.getName().toUpperCase());
			if (count.decrementAndGet() > 0)
				sb.append(",");
		}
		sb.append(") VALUES(");
		// Object value = f.get(t);

		return null;
	}
}
