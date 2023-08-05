package com.qa.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandlingFrames {

    public static WebDriver driver;
    WebElement frame1;
    WebElement frame2;
    String text1;
    String text2;

    List<WebElement> frames;

    @BeforeClass
    public static void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vahini Shyam\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://demoqa.com/frames");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void switchFrames()
    {
        frame1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1);
        text1 = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(text1);

        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.xpath("//div[text() = 'Frames']")).isDisplayed());

        frame2 = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(frame2);
        text2 = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(text2);

        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Sample Iframe page')]")).isDisplayed());

    }

    @Test
    public void idenitifyFrames()
    {
        frames = driver.findElements(By.tagName("iframe"));
        System.out.println("No of frames: " +frames.size());


    }

}
