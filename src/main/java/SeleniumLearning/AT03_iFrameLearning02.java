package SeleniumLearning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AT03_iFrameLearning02 {

    @Test
    public void frame02() throws InterruptedException {
        //setup the chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.harveynorman.com.au/signup");
        //Wait few seconds for the page to load
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
// from this we got to know there are 3 frames
        List<WebElement> ListofFrames=driver.findElements(By.tagName("iframe"));
        int ListSize=ListofFrames.size();

        driver.switchTo().frame(0);
        driver.findElement(By.id("firstName")).sendKeys("Test");

        driver.switchTo().frame(1);
        driver.switchTo().frame(2);

        System.out.println("ListSize : "+ListSize);
        for(int i=0;i<ListSize;i++){
            driver.switchTo().frame(0);
            driver.findElement(By.id("firstName")).sendKeys("Test");
            break;
        }


    }
}