package com.contacts.testing;

import java.io.IOException;

import org.junit.Test;
import org.mockito.Mock;

import com.contacts.Controller.Main;

public class TestMain {
	
	@Mock
	public Main main;

	@Test
	public void testMain() throws IOException{

		
		String[] args = {"arg1","arg2"};
		Main.main(args);
		
	}

}
