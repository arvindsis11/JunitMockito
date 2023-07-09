package com.arvind.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ListMock {

	

	
	@Test
	void testList() {
		List list = mock(List.class);
		when(list.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, list.size());
		assertEquals(3,list.size());
		Mockito.times(0);
		
		
	}
	
	@Test
	void throwExe() {
		String str = null;
		List list = mock(List.class);
		when(list.size()).thenThrow(new RuntimeException());
		assertThrows(RuntimeException.class, ()->{
			list.size();
		});
	}

}
