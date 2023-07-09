package com.arvind.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class TodoServiceImplTestStub {

	TodoService todoService;
	ApiService apiService;

	@BeforeEach
	public void setup() {
		apiService = new ApiServiceImpl();
		todoService = new TodoServiceImpl(apiService);
	}

	@Test
	public void testGetName() {
		String name = "John";
		String result = todoService.getName(name);
		assertEquals(name, result);
	}

	@Test
	public void testGetData() {
		List<String> expectedNames = Arrays.asList("arvind", "Bob", "Charlie");

		List<String> result = todoService.getData();

		assertEquals(expectedNames.size(), result.size());
//		assertThat(result).containsAll(expectedNames);
		assertThat(result).containsAnyElementsOf(expectedNames);

	}
	
	@Test
	void testException() {
		String str = null;
		
		assertThrows(NullPointerException.class, ()->{
			str.length();
		});
	}
	
	@Test
	@DisplayName("hello this is test name")
	@Disabled
	void testExeptionWay2() {
		assertTrue(true);
	}
}
