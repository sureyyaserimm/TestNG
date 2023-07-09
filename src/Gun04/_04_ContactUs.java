package Gun04;

/*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra Contact US yazısını doğrulayınız.
 */

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _04_ContactUs extends BaseDriver {

    @Test
    @Parameters("message")
        //xml'deki parametre adı aynı olmak zorunda
    void contactUs(String newMessage) {
        // String newMessage= xml'deki parametre adı aynı olmak zorunda değil
        WebElement contactUs = driver.findElement(By.linkText("Contact Us"));
        contactUs.click();

        WebElement enquiryArea = driver.findElement(By.id("input-enquiry"));
        enquiryArea.sendKeys(newMessage);

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));
    }


}
