package com.qa.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HandleSSLCertificate {

    public WebDriver driver;

    /*@BeforeClass
    public static void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vahini Shyam\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));



    }*/

    @Test
    public void withoutSslCertificate() throws InterruptedException {
        driver.get("https://expired.badssl.com/");
        System.out.println("The page title is: " + driver.getTitle());
    }

    @Test
    public void withSslCertificate() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vahini Shyam\\Downloads\\chromedriver\\chromedriver.exe");

        ChromeOptions ssl = new ChromeOptions();
        ssl.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(ssl);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://expired.badssl.com/");
        System.out.println("The page title is: " + driver.getTitle());
    }


    /*@AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }*/


}
