package StepDefinations;

import BaseClass.OpenBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.io.IOException;

public class SD02_CreateMultipleAcc {

    @Given("navigate to Registration screen of HN website")
    public void navigate_to_registration_screen_of_hn_website() throws IOException {
        OpenBrowser.NavToWebsite("urlCreate");
    }
    @Then("customer enters firstname as {string}")
    public void customer_enters_firstname_as(String FirstName) {
        OpenBrowser.driver.findElement(By.id("firstname")).clear();
        OpenBrowser.driver.findElement(By.id("firstname")).sendKeys(FirstName);
    }
    @Then("customer enters lastname as {string}")
    public void customer_enters_lastname_as(String LastName) {
        OpenBrowser.driver.findElement(By.id("lastname")).clear();
        OpenBrowser.driver.findElement(By.id("lastname")).sendKeys(LastName);
    }
    @Then("customer enters emailadd as {string}")
    public void customer_enters_emailadd_as(String EmailAdd) {
        OpenBrowser.driver.findElement(By.id("email_address")).clear();
        OpenBrowser.driver.findElement(By.id("email_address")).sendKeys(EmailAdd);
    }
    @Then("customer enters pass as {string}")
    public void customer_enters_pass_as(String Password) {
        OpenBrowser.driver.findElement(By.id("password")).clear();
        OpenBrowser.driver.findElement(By.id("password")).sendKeys(Password);
    }
    @Then("customer enters repass as {string}")
    public void customer_enters_repass_as(String RePassword) {
        OpenBrowser.driver.findElement(By.id("confirmation")).clear();
        OpenBrowser.driver.findElement(By.id("confirmation")).sendKeys(RePassword);
    }
}
