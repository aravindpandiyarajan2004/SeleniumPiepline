package com.aravind.textile.serviceimpl;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ CustomerServiceImplTest.class, OrderServiceImplTest.class, UserServiceImplTest.class })
public class AllTests {

}
