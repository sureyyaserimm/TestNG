package TestingProject4.Source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Tools2 {
    public static void Bekle(int saniye){
        try {
            Thread.sleep(1000 * saniye);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void successMessageValidation(){
        WebElement  messageTrue         =   BaseDriver2.driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertTrue(messageTrue.getText().toLowerCase().contains("success"));
    }
}
