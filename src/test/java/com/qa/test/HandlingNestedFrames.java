package com.qa.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingNestedFrames {

    public static WebDriver driver;

    WebElement frame1;
    WebElement frame2;
    String text1;
    String text2;
    String defaultContent;

    @BeforeClass
    public static void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vahini Shyam\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://demoqa.com/nestedframes");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void identifyFrames()
    {
        int framesCount = driver.findElements(By.tagName("iframe")).size();
        System.out.println(framesCount);

        frame1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1);

        text1 = driver.findElement(By.tagName("body")).getText();

        System.out.println("Parent frame text is: " +text1);

        frame2 = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame2);

        text2 = driver.findElement(By.tagName("body")).getText();
        System.out.println("Child frame text is: " +text2);

        driver.switchTo().parentFrame();
        System.out.println("Parent frame text is: " +text1);

        driver.switchTo().defaultContent();
        defaultContent = driver.findElement(By.xpath("//div[@id = 'framesWrapper']/div")).getText();
        System.out.println(defaultContent);


    }
}
