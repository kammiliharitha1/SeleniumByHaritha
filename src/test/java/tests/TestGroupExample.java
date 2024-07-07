//package tests;
//
//	import org.testng.annotations.AfterTest;
//	import org.testng.annotations.BeforeTest;
//	import org.testng.annotations.Test;
//
//	public class TestGroupExample {
//
//	    @BeforeTest
//	    public void beforeTest() {
//	        System.out.println("Before Test - Runs before all test cases in the test tag.");
//	    }
//
//	    @AfterTest
//	    public void afterTest() {
//	        System.out.println("After Test - Runs after all test cases in the test tag.");
//	    }
//
//	    @Test(groups = {"group1"})
//	    public void test1() {
//	        System.out.println("Test 1 - Group 1");
//	    }
//
//	    @Test(groups = {"group1"})
//	    public void test2() {
//	        System.out.println("Test 2 - Group 1");
//	    }
//
//	    @Test(groups = {"group2"})
//	    public void test3() {
//	        System.out.println("Test 3 - Group 2");
//	    }
//
//	    @Test(groups = {"group2"})
//	    public void test4() {
//	        System.out.println("Test 4 - Group 2");
//	    }
//	}
//
//
//
