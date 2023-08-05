package com.qa.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithBrowser
{
    WebDriver driver;
    String url = "https://jqueryui.com/";

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vahini Shyam\\Downloads\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get(url);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test
    public void getPageTitle()
    {
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
