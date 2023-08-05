package com.qa.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class DragAndDrop {

    public static WebDriver driver;
    WebElement source;
    WebElement target;

    @BeforeClass
    public static void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vahini Shyam\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://demoqa.com/droppable/");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void bySourceTarget()
    {
        source = driver.findElement(By.id("draggable"));
        System.out.println(source.getText());
        target = driver.findElement(By.id("droppable"));
        System.out.println(target.getText());

        Actions action = new Actions(driver);
        action.dragAndDrop(source,target).build().perform();
        System.out.println(target.getText());
    }

    @Test
    public void byOffset()
    {
        source = driver.findElement(By.id("draggable"));
        System.out.println(source.getText());
        target = driver.findElement(By.id("droppable"));
        System.out.println(target.getText());

        int x = source.getLocation().getX();
        int y = source.getLocation().getY();

        System.out.println(x +" "+ y);

        int x1 = target.getLocation().getX();
        int y1 = target.getLocation().getY();

        System.out.println(x1 +" "+ y1);

        int x2 = (x1-x) + 10;
        int y2 = (y1-y) + 20;

        Actions action = new Actions(driver);
        action.dragAndDropBy(source,x2,y2).build().perform();
        System.out.println(target.getText());
    }
}
