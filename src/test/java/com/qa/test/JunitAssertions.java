package com.qa.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JunitAssertions {

    WebDriver driver;

    WebElement logo;

    WebElement element;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vahini Shyam\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://jqueryui.com/");
    }

    @Test
    public void assertTrue()  //Pass
    {
        logo = driver.findElement(By.xpath("//h2[@class = 'logo']/a[text() = 'jQuery UI']"));

        System.out.println("Logo is displayed - "+logo.isDisplayed());
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void assertFalse() //Fail - Assertion EQrror
    {
        logo = driver.findElement(By.xpath("//h2[@class = 'logo']/a[text() = 'jQuery UI']"));
        System.out.println("Logo is displayed - "+logo.isDisplayed());

        Assert.assertFalse(logo.isDisplayed());
    }

    @Test
    public void assertEquals()  //Fail - Assertion Error
    {
        logo = driver.findElement(By.xpath("//h2[@class = 'logo']/a[text() = 'jQuery UI']"));
        System.out.println("Logo text is " +logo.getText());

        Assert.assertEquals("Logo is correct", "jQuery UI", logo.getText());
    }

    @Test
    public void assertNotEquals()  //Pass
    {
        logo = driver.findElement(By.xpath("//h2[@class = 'logo']/a[text() = 'jQuery UI']"));
        System.out.println("Logo text is " +logo.getText());

        Assert.assertNotEquals("Logo is correct", "jQuery UI", logo.getText());
    }

    @Test
    public void assertNull() //Fail - Assertion Error
    {
        Assert.assertNull("Object is not null", driver);
    }

    @Test
    public void assertNotNull() //Fail - Assertion Error
    {
        System.out.println("element is " + element);
        Assert.assertNotNull("Object is null", element);
        System.out.println(element);
    }


    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
