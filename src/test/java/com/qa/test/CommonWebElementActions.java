package com.qa.test;

import org.joda.time.Seconds;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommonWebElementActions {

    WebDriver driver;
    WebElement email;
    WebElement password;
    WebElement rememberMe;
    WebElement login;
    WebElement loginPageText;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vahini Shyam\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://admin-demo.nopcommerce.com/login");
    }

    @Test
    public void elementActions()
    {
        email = driver.findElement(By.id("Email"));
        password = driver.findElement(By.id("Password"));
        rememberMe = driver.findElement(By.id("RememberMe"));
        login = driver.findElement(By.xpath("//button[text() = 'Log in']"));
        loginPageText = driver.findElement(By.xpath("//h2[text() = 'Defaults for admin area']"));

        email.clear();
        email.sendKeys("admin@yourstore.com");
        System.out.println(email.getText());

        password.clear();
        password.sendKeys("admin");
        System.out.println(password.isDisplayed());

        System.out.println(rememberMe.isEnabled());
        rememberMe.click();
        System.out.println(rememberMe.isSelected());

        //System.out.println(loginPageText.getCssValue());
        System.out.println(loginPageText.getSize());
        System.out.println(loginPageText.getLocation());

        System.out.println(login.getTagName());
        login.submit();



    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
