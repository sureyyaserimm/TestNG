package TestingProject4.Homework;

import TestingProject4.Source.BaseDriverParameter2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class Project5 extends BaseDriverParameter2 {
    @Test
    void ordersGift() {
        WebElement gift = driver.findElement(By.linkText("Gift Cards"));
        gift.click();

        List<WebElement> physical = driver.findElements(By.cssSelector("h2[class='product-title']>a"));
        Random rastgele = new Random();
        int kacinciEleman = rastgele.nextInt(physical.size());
        if (physical.get(kacinciEleman).getText().contains("Physical")) {
            physical.get(kacinciEleman).click();
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[class='recipient-name']")));

        WebElement recipients = driver.findElement(By.cssSelector("input[class='recipient-name']"));
        recipients.sendKeys("Süreya Serim");

        WebElement yourName = driver.findElement(By.cssSelector("input[class='sender-name']"));
        yourName.sendKeys("Talha Balaban");

        WebElement message = driver.findElement(By.cssSelector("textarea[class='message']"));
        message.sendKeys("Hellooo! Projeyi bitirdik öğretmenim :)");

        WebElement addCart = driver.findElement(By.cssSelector("button[class='button-1 add-to-cart-button']"));
        addCart.click();

        WebElement alertSuccess = driver.findElement(By.cssSelector("[class='bar-notification success']>p"));
        Assert.assertEquals(alertSuccess.getText().contains("shopping cart"), true);


    }
}
