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

public class AT06_GetAttValNListNisSelected {

    @Test
    public void enabled() {
        //setup the chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://www.echoecho.com/htmlforms10.htm");

        //Wait few seconds for the page to load
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Get all radio buttons into list
        List<WebElement> listOfRadioButtons = driver.findElements(By.name("radio1"));
        // we know the size as 3
        int sizeofRadio = listOfRadioButtons.size();
        System.out.println("size of radio buttons is : " + sizeofRadio);
// go into loop
        for (WebElement listOfRadioButton : listOfRadioButtons) {
            //get attribute value -- radio
            String ValAtt = listOfRadioButton.getAttribute("type");
            // radio is value printed on console
            System.out.println("Value of attribute is : " + ValAtt);
            //if radio=radio then go into if loop
            if (ValAtt.equalsIgnoreCase("radio")) {
                // is the first radio button selected ?
                boolean check = listOfRadioButton.isSelected();
                //if not selected, then we go into if loop
                if (!check) {
                    //now lets click on the first one
                    listOfRadioButton.click();

                }


            }
        }


    }
}
