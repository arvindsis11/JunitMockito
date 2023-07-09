package com.arvind.service;

import java.util.List;

public class TodoServiceImpl implements TodoService {

	private ApiService api;

	public TodoServiceImpl(ApiService api) {
		this.api = api;
	}

	@Override
	public String getName(String name) {
		return name;
	}

	@Override
	public List<String> getData() {
		List<String> names = api.getAll();// mocking api call
		return names;
	}

	@Override
	public int square(int number)  {
		return number * number;
	}

}
