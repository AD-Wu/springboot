package com.ad.springboot.dao.sql;

public class Update {

	private String k;
	private Object v;

	public Update() {
	}

	public Update(String key, Object value) {
		this.k = key;
		this.v = value;
	}

	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}

	public Object getV() {
		return v;
	}

	public void setV(Object v) {
		this.v = v;
	}

	public boolean isValid() {
		return k == null ? false : ("".equals(k.trim()) ? false : true);
	}

}
