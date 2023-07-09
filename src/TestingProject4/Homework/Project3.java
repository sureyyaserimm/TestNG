package TestingProject4.Homework;

import TestingProject4.Source.BaseDriverParameter2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Project3 extends BaseDriverParameter2 {
    @Test(dataProvider = "UserData")
    void loginTest(String email, String password) {

        WebElement login = driver.findElement(By.linkText("Log in"));
        login.click();

        WebElement email2 = driver.findElement(By.cssSelector("input[name='Email']"));
        email2.clear();
        email2.sendKeys(email);

        WebElement password2 = driver.findElement(By.cssSelector("input[name='Password']"));
        password2.clear();
        password2.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.cssSelector("button[class='button-1 login-button']"));
        loginBtn.click();

        if (email2.equals("aAa@gmail.com") && password2.equals("1")) {
            WebElement verify = driver.findElement(By.cssSelector("a[class='ico-logout']"));
            Assert.assertEquals(verify.getText(), "Log out", "Parola Hatalı");
        }
        else if (email2.equals("abc123@gmail.com") && password2.equals("s1f2y3u6")) {
            WebElement verify = driver.findElement(By.cssSelector("a[class='ico-logout']"));
            Assert.assertEquals(verify.getText(), "Log out", "Parola Hatalı");
        }
    }
    @DataProvider
    public Object[][] UserData() {

        Object[][] data = {

                {"aAa@gmail.com", "1"},
                {"abc123@gmail.com", "s1f2y3u6"},
        };

        return data;
    }
}
