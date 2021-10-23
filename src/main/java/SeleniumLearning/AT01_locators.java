package SeleniumLearning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AT01_locators {
    @Test
    public void locLearn() throws InterruptedException {
        //setup the chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.harveynorman.com.au/customer/account/create/");
        // here we are learning how to use locator "id"
        //	driver.findElement(By.id("firstname")).sendKeys("test");
        // locator: name
        //driver.findElement(By.name("firstname")).sendKeys("test");
        //locator: css
        //driver.findElement(By.cssSelector("#firstname")).sendKeys("test");
        //locator: xpath
        //	driver.findElement(By.xpath("//*[@id=\'firstname\']")).sendKeys("test");
//locator: linktext
        driver.findElement(By.linkText("Newsletter sign up")).click();

        //Wait few seconds for the page to load
        //	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(20000);
//locator: linktext
        driver.findElement(By.partialLinkText("Vacuum & ")).click();


    }
}


