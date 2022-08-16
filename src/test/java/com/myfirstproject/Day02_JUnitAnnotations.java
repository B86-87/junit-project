package com.myfirstproject;

import org.junit.*;

public class Day02_JUnitAnnotations {
/*
@Test is used to create test cases
All test methods should be void
We cannot run methods without @Test
@BeforeClass is used to run once before the entire class
@BeforeClass is also used for PRECONDITION
@AfterClass is sued to run once after the entire class
@AfterClass is also used for AFTERCONDITION
@Before is used to run before each @Test method
@After is used to run after each @Test method
@Ignore is used to skip/ignore a @Test method
* */

    @BeforeClass
    public static void setUpClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public static void tearDownClass(){
        System.out.println("After Class");
    }
    @Before
    public void setUpMethod(){
        System.out.println("Before Method");
    }
    @After
    public void tearDownMethod(){
        System.out.println("After Method. Reports. Driver close.");
    }
    @Test
    public void test1(){
        System.out.println("Test 1");
    }

    @Test @Ignore
    public void test2(){
        System.out.println("Test 2");
    }

    @Test
    public void test3(){
        System.out.println("Test 3");
    }
    @Test
    public void test4(){
        System.out.println("Test 4");
    }


}
