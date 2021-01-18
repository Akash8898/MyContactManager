package com.contacts.testing;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.contacts.utilities.Operations;
import com.contacts.utilities.Utilities;

@RunWith(MockitoJUnitRunner.class)
public class TestOperations {
	
	@InjectMocks
	private Operations op;
	
	@Mock
	private Utilities utils;
	
	//@Mock
	private Scanner scan = new Scanner(System.in);
	
	List<String> lists = new ArrayList<>();
	
//	@Before
//	public void setup() throws IOException {
//		//when(scan.next()).thenReturn("abcd");
//		lists.add("abcd");
//		when(utils.fileSearch(Mockito.anyString())).thenReturn(lists);
//	}
	
	
	
//	@Test
//	public void test_case_1() {
//		
//		//when(scan.nextInt()).thenReturn(1);
//		
//		String input = "1";
//		
//	    InputStream in = new ByteArrayInputStream(input.getBytes());
//	    System.setIn(in);
//	    
//		
//		op.mainProcess(utils);
//		
//	}
//	
//	@Test
//	public void test_case_2() {
//		
//		when(scan.nextInt()).thenReturn(2);
//		op.mainProcess(utils,scan);
//		
//	}
//	
//	@Test
//	public void test_case_3() {
//		
//		when(scan.nextInt()).thenReturn(3);
//		op.mainProcess(utils,scan);
//		
//	}
//	
//	
//	@Test
//	public void test_case_4() {
//		
//		when(scan.nextInt()).thenReturn(4);
//		op.mainProcess(utils,scan);
//		
//	}
//	
//	
//	@Test
//	public void test_case_5() {
//		
//		when(scan.nextInt()).thenReturn(5);
//		op.mainProcess(utils,scan);
//		
//	}
//	
//	
//	@Test
//	public void test_case_6() {
//		
//		when(scan.nextInt()).thenReturn(6);
//		op.mainProcess(utils,scan);
//		
//	}
//	
//
//	@Test
//	public void test_case_exception_1() {
//		
//		when(scan.nextInt()).thenReturn(1);
//		when(utils.formatNumber(Mockito.anyLong(), Mockito.anyInt())).thenThrow(InputMismatchException.class);
//		
//	}
//	
//
//	@Test
//	public void test_case_exception_2() {
//		when(scan.nextInt()).thenReturn(1);
//		when(utils.formatNumber(Mockito.anyLong(), Mockito.anyInt())).thenThrow(InputMismatchException.class);
//		op.mainProcess(utils,scan);
//		
//	}
//	
	
	@Test
	public void noTest() {
	
	}
	

}
