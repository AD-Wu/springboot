package com.ad.springboot.bean;

import java.util.Date;

public class User {
	private int id;
	private final String name;
	private final int age;
	private final Date birthday;
	private final String tel;

	public User(Builder b) {
		name = b.name;
		age = b.age;
		birthday = b.birthday;
		tel = b.tel;
	}

	public static class Builder {
		private final String name;
		private final int age;
		private Date birthday;
		private String tel;

		public Builder(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public Builder birthday(Date birthday) {
			this.birthday = birthday;
			return this;
		}

		public Builder tel(String tel) {
			this.tel = tel;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

	// 必须提供所有属性的get方法，否则无法获取数据，无法将数据自动转换为Json数据
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getTel() {
		return tel;
	}

}
