package TestingProject4.Homework;

import TestingProject4.Source.BaseDriverParameter2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Project2 extends BaseDriverParameter2 {
    @Test
    void loginTest(){

        WebElement  login           =   driver.findElement(By.linkText("Log in"));
        login.click();

        WebElement  firstName       =   driver.findElement(By.cssSelector("input[name='Email']"));
        firstName.sendKeys("talhabalaban3@aws.com");

        WebElement  password        =   driver.findElement(By.cssSelector("input[name='Password']"));
        password.sendKeys("1f5?s!a4r62?");

        WebElement  loginBtn        =   driver.findElement(By.cssSelector("button[class='button-1 login-button']"));
        loginBtn.click();

        WebElement  verify          =   driver.findElement(By.cssSelector("a[class='ico-logout']"));
        Assert.assertEquals(verify.getText(),"Log out","Parola Hatalı");
    }
}
