package com.qa.test;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.apache.logging.log4j.Logger.*;

public class Log4jTest {

    public WebDriver driver;
    public static Logger log;

    @Test
    public void setUp() throws InterruptedException {

        Configurator.initialize(new DefaultConfiguration());
        Configurator.setRootLevel(Level.INFO);


        log = LogManager.getLogger(Log4jTest.class);


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vahini Shyam\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        log.info("Browser launched");

        driver.manage().window().maximize();
        log.info("Browser maximized");

        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://demoqa.com/alerts");
        log.info("Home Page launched");

        Thread.sleep(2000);
        driver.close();
        log.info("Browser closed");
    }


}
