package SeleniumLearning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AT02_iFrameLearning01 {

    @Test
    public void frame01() throws InterruptedException {
        //setup the chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.harveynorman.com.au/signup");
        //Wait few seconds for the page to load
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //below line will take us to the frame
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='mobSubscribe ']")));
        driver.findElement(By.id("firstName")).sendKeys("Test");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //switch to parent window
        driver.switchTo().parentFrame();
        //click on sitemap
        String mapname= driver.findElement(By.xpath("//a[contains(text(),'Sitemap')]")).getText();
        System.out.println(mapname);
        Assert.assertEquals(mapname,"Sitemap");
        //again jump to iframe and enter password
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='mobSubscribe ']")));
        driver.findElement(By.id("emailId")).sendKeys("labtest285@gmail.com");

        //switch to parent window
        driver.switchTo().parentFrame();

    }
}