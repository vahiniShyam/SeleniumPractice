package com.qa.test;

import org.junit.*;

public class JUnitAnnotations {

    @BeforeClass
    public static void beforeClass()
    {
        System.out.println("Inside Before Class method");
    }

    @AfterClass
    public static void afterClass()
    {
        System.out.println("Inside After Class method");
    }

    @Before
    public void before()
    {
        System.out.println("Inside Before method");
    }

    @After
    public void after()
    {
        System.out.println("Inside After method");
    }

    @Test
    public void test1()
    {
        System.out.println("Inside Test1 method");
    }

    @Test
    public void test2()
    {
        System.out.println("Inside Test2 method");
    }

    @Test
    public void test3()
    {
        System.out.println("Inside Test3 method");
    }
}
