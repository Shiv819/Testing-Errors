package Registeration;

import BaseClass.OpenBrowser;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.IOException;

public class AT02_CreateUsers {

    @Test
    public void navigate() throws IOException {
        OpenBrowser.NavToWebsite("urlCreate");
    }

    @Test
    public void Fname(){
        OpenBrowser.driver.findElement(By.id("firstname")).clear();
        OpenBrowser.driver.findElement(By.id("firstname")).sendKeys("");

    }
    @Test
    public void Lname(){

    }
    @Test
    public void Eadd(){

    }
    @Test
    public void pass(){

    }
    @Test
    public void repass(){

    }


}
