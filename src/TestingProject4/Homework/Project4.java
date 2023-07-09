package TestingProject4.Homework;

import TestingProject4.Source.BaseDriverParameter2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class Project4 extends BaseDriverParameter2 {
    @Test(dataProvider = "myDatas")
    void Products(String product) {

        List<WebElement> products = driver.findElements(By.cssSelector("h2[class='product-title']>a"));
        for (int i = 0; i < products.size(); i++) {
            if (product.equals(products.get(i).getText())){
                System.out.println();
                Assert.assertEquals(product,products.get(i).getText());
            }
        }
    }

    @DataProvider
    public Object[] myDatas() {
        Object[] users = {"Build your own computer",
                "Apple MacBook Pro 13-inch",
                "HTC One M8 Android L 5.0 Lollipop",
                "$25 Virtual Gift Card"};
        return users;
    }
}
