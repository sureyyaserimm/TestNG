package Gun02;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Ornek extends BaseDriver {

    @Test
    void loginTest(){

        System.out.println("Login Test");

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement inputEmail=driver.findElement(By.id("input-email"));
        inputEmail.sendKeys("anarkokomunist@marksist.com");

        WebElement password=driver.findElement(By.id("input-password"));
        password.sendKeys("0123456");

        Tools.Bekle(2);

        WebElement login=driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();

        Assert.assertTrue(driver.getTitle().equals("My Account"));
        //Assert.assertTrue(driver.getCurrentUrl().contains("account/account"));

    }
}
