package com.ad.springboot.dao.sql;

public class Where extends Update {

	private String o;

	public Where() {
	}

	public Where(String k, String o, Object v) {
		super(k, v);
		this.o = o;
	}

	public String getO() {
		return o;
	}

	public void setO(String o) {
		this.o = o;
	}

	@Override
	public boolean isValid() {
		if (super.isValid())
			return o == null ? false : ("".equals(o.trim()) ? false : true);
		return false;

	}

}
