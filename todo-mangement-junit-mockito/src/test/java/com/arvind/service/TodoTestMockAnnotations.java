package com.arvind.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // this is important to inject mocks
public class TodoTestMockAnnotations {

	@Mock
	ApiService apiService;

	@InjectMocks
	TodoServiceImpl todoService;

	@Test
	public void testGetName() {
//		 ApiService apiService = mock(ApiService.class);
//		 TodoService todoService = new TodoServiceImpl(apiService);
		String name = "John";
		String result = todoService.getName(name);
		assertEquals(name, result);
	}

	@Test
	public void testGetData() {
//		 ApiService apiService = mock(ApiService.class);
//		 TodoService todoService = new TodoServiceImpl(apiService);
		List<String> expectedNames = Arrays.asList("Alice", "Bob", "Charlie");
		when(apiService.getAll()).thenReturn(expectedNames);

		List<String> result = todoService.getData();

		assertEquals(expectedNames.size(), result.size());
		verify(apiService, times(1)).getAll();

	}

	@Test
	void testGetNameVerify() {
		String name = todoService.getName("arvind");
		assertSame("arvind", name);
//		verify(apiService).getAll();//zero interactions--
		verify(apiService, never()).getAll();// unused method
		verifyNoMoreInteractions(apiService);
	}

	// parameterized testing

	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3, 4 })
	public void squareTestParameterized(int n) {
		int expected = n * n;
		int actual = todoService.square(n);
		assertEquals(expected, actual);
	}

	@ParameterizedTest
	@MethodSource("provideNumbers")
	public void testSquare(int number) {
		int expected = number * number;
		int actual = todoService.square(number);
		assertEquals(expected, actual);
	}

	private static List<Integer> provideValues() {
		return Arrays.asList(1, 2, 3);
	}
	private static Stream<Integer> provideNumbers() {
		return Stream.of(1, 2, 3);
	}
	private static Iterable<Integer> provideValuesList() {
        return Arrays.asList(1, 2, 3);
    }
	 private static Integer[] provideArray() {
	        return new Integer[] { 1, 2, 3 };
	    }
}
