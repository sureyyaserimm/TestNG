package TestingProject4.Homework;

import TestingProject4.Source.BaseDriver2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Project1 extends BaseDriver2 {
    @Test
    void registerTest(){


        WebElement cinsiyet        =   driver.findElement(By.xpath("//input[@id='gender-female']"));
        cinsiyet.click();

        WebElement  firstName       =   driver.findElement(By.xpath("//input[@name='FirstName']"));
        firstName.sendKeys("Talha");

        WebElement  lastName        =   driver.findElement(By.xpath("//input[@name='LastName']"));
        lastName.sendKeys("Balaban");

        WebElement  birthDaySelect  =   driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        Select birthDay            =   new Select(birthDaySelect);
        birthDay.selectByIndex(5);

        WebElement  birthMOnthSelect=   driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        Select  birthMonth          =   new Select(birthMOnthSelect);
        birthMonth.selectByIndex(8);

        WebElement  birthYearSelect =   driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        Select  birthYear           =   new Select(birthYearSelect);
        birthYear.selectByIndex(25);

        WebElement  email           =   driver.findElement(By.xpath("//input[@name='Email']"));
        email.sendKeys("talhabalaban4@aws.com");

        WebElement  pass            =   driver.findElement(By.xpath("//input[@name='Password']"));
        pass.sendKeys("1f5?s!a4r62?");

        WebElement  confPass        =   driver.findElement(By.xpath("//input[@name='ConfirmPassword']"));
        confPass.sendKeys("1f5?s!a4r62?");

        WebElement continue4        =   wait.until(ExpectedConditions.elementToBeClickable(By.id("register-button")));
        continue4.click();

        WebElement  successMessage         =   driver.findElement(By.xpath("//div[text()='Your registration completed']"));
        Assert.assertEquals(successMessage.getText(),"Your registration completed","Tebrikler, kayıt başarılı!");



    }
}
