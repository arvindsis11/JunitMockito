package com.arvind.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodoServiceImplTestMockito {



//	@BeforeAll
//	public static void setup() {
//		apiService = new ApiServiceImpl();
//		ApiService mockObj = mock(ApiService.class);
//		todoService = new TodoServiceImpl(mockObj);
//	}

	@Test
	public void testGetName() {
		 ApiService apiService = mock(ApiService.class);
		 TodoService todoService = new TodoServiceImpl(apiService);
		String name = "John";
		String result = todoService.getName(name);
		assertEquals(name, result);
	}

	@Test
	public void testGetData() {
		 ApiService apiService = mock(ApiService.class);
		 TodoService todoService = new TodoServiceImpl(apiService);
		List<String> expectedNames = Arrays.asList("Alice", "Bob", "Charlie");
		when(apiService.getAll()).thenReturn(expectedNames);

		List<String> result = todoService.getData();

		assertEquals(expectedNames.size(), result.size());
		

	}
}
