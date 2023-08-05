import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WebTables {

    public static WebDriver driver;

    WebElement table;
    List<WebElement> rows;
    List<WebElement> cols;
    WebElement element;

    @BeforeClass
    public static void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vahini Shyam\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://demo.guru99.com/test/web-table-element.php");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void selectCellValue() throws InterruptedException {
        table = driver.findElement(By.xpath("//table[@class = 'dataTable']"));
        rows = table.findElements(By.tagName("tr"));
        System.out.println("No of rows: " +rows.size());


        for (WebElement row : rows)
        {
            cols = row.findElements(By.tagName("td"));


            for (WebElement col : cols) {
                System.out.println(col.getText());
                //cols.get(1).click();
                /*element = col.findElement(By.xpath("//table[@class = 'dataTable']/tbody/tr/td/a"));
                if(element.getText().equals("NCC"));
                element.click();*/
            }

        }
        System.out.println("No of columns:" + cols.size());



    }

}
