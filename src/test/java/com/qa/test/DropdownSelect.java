package com.qa.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropdownSelect {

    public static WebDriver driver;
    WebElement color;
    WebElement cars;

    @BeforeClass
    public static void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vahini Shyam\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://demoqa.com/select-menu");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void singleSelect() throws InterruptedException {
        color = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(color);

        List<WebElement> colorList =  select.getOptions();

        for(WebElement color : colorList)
            System.out.println("The colors are: " +color.getText());

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        Thread.sleep(1000);
        select.selectByValue("3");

        Thread.sleep(1000);
        select.selectByVisibleText("White");

        System.out.println(select.isMultiple());

        List<WebElement> selected = select.getAllSelectedOptions();
        System.out.println(selected.get(0).isSelected());
        System.out.println(selected.get(0).getText());
    }

    @Test
    public void multiSelect() throws InterruptedException {
        cars = driver.findElement(By.id("cars"));
        Select select = new Select(cars);

        List<WebElement> carsList =  select.getOptions();

        for(WebElement car : carsList)
            System.out.println("The cars are: " +car.getText());

        System.out.println(select.isMultiple());

        select.selectByIndex(0);
        System.out.println(select.getFirstSelectedOption().getText());

        Thread.sleep(1000);
        select.selectByValue("saab");

        Thread.sleep(1000);
        select.selectByVisibleText("Opel");

        Thread.sleep(1000);
        select.selectByVisibleText("Audi");

        List<WebElement> selected = select.getAllSelectedOptions();
        for (WebElement selectedOptions : selected)
            System.out.println(selectedOptions.getText());

        Thread.sleep(1000);
        select.deselectByIndex(0);
        Thread.sleep(1000);
        select.deselectByValue("saab");
        Thread.sleep(1000);
        select.deselectByVisibleText("Opel");
        Thread.sleep(1000);
        select.selectByValue("volvo");
        List<WebElement> selectedAgain = select.getAllSelectedOptions();
        for (WebElement selectedAgainOptions : selectedAgain)
            System.out.println(selectedAgainOptions.getText());
        Thread.sleep(1000);
        select.deselectAll();

    }
}
