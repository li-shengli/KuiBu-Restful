package com.selfstudy.kuibu.vo;

import java.util.List;

public class Result<T> {
	private List<T> data;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
