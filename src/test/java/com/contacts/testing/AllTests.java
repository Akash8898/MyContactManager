package com.contacts.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({  TestUtilities.class, TestOperations.class, TestMain.class })
public class AllTests {
	
}
