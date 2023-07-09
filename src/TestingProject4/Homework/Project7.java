package TestingProject4.Homework;

import TestingProject4.Source.BaseDriverParameter2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Project7 extends BaseDriverParameter2 {
    @Test
    @Parameters("Search")
    void SearchTest(String Search){
        WebElement  inputSearch      =   driver.findElement(By.id("small-searchterms"));
        inputSearch.sendKeys(Search);

        WebElement  searchButton     =   driver.findElement(By.cssSelector("button[class='button-1 search-box-button']"));
        searchButton.click();

        WebElement  pageContains     =   driver.findElement(By.cssSelector("h2[class='product-title']>a"));
        Assert.assertEquals(pageContains.getText(),Search);

    }
}
