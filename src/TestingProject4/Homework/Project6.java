package TestingProject4.Homework;

import TestingProject4.Source.BaseDriverParameter2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class Project6 extends BaseDriverParameter2 {
    @Test
    void orderComputerTest(){

        Actions     aksiyonlar      =   new Actions(driver);

        WebElement  computerTab     =   driver.findElement(By.cssSelector("ul[class='top-menu notmobile']>li>a[href='/computers']"));
        aksiyonlar.moveToElement(computerTab).build().perform();

        WebElement  desktopBtn      =   driver.findElement(By.cssSelector("ul[class='sublist first-level']>li>a[href='/desktops']"));
        desktopBtn.click();

        WebElement  desktopSelect   =   driver.findElement(By.cssSelector("h2[class='product-title']>a"));
        desktopSelect.click();

        WebElement  drop            =   driver.findElement(By.id("product_attribute_2"));
        aksiyonlar.moveToElement(drop).build().perform();


        List<WebElement> ram        =   driver.findElements(By.cssSelector("select[name='product_attribute_2']>option"));
        Random      rast            =   new Random();
        int         index           =   rast.nextInt(ram.size());
        ram.get(index).click();

        List<WebElement> hdd        =   driver.findElements(By.cssSelector("ul>li>input[name='product_attribute_3']"));
        int         hddIndex        =   rast.nextInt(hdd.size());
        hdd.get(hddIndex).click();

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebElement  addCart         =   driver.findElement(By.xpath("//*[@class='button-1 add-to-cart-button']"));
        addCart.click();


        WebElement  alertSuccess        =   driver.findElement(By.cssSelector("[class='bar-notification success']>p"));
        Assert.assertEquals(alertSuccess.getText().contains("shopping cart"),true);



    }
}
