package com.arvind.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApiServiceImpl implements ApiService{

	@Override
	public List<String> getAll() {
		System.out.println("checking if this is called or not");
		return Stream.of("rohit","aman","arvind").collect(Collectors.toList());
	}

}
