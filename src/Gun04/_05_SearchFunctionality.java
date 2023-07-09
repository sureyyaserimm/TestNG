package Gun04;

/*
      Senaryo ;
      1- Siteyi açınız.
      2- mac kelimeini göndererek aratınız.
      3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
      4- aynı işlemi samsung için de yapınız
    */

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _05_SearchFunctionality extends BaseDriver {

    @Test
    @Parameters("aranacakKelime")
    void searchFonction(String text){
        WebElement searchInput=driver.findElement(By.cssSelector("[name='search']"));
        searchInput.sendKeys(text);

        WebElement searchButton=driver.findElement(By.cssSelector("[class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> captions=driver.findElements(By.cssSelector("div[class='caption']>h4"));

        for (WebElement e :captions)
            Assert.assertTrue(e.getText().toLowerCase().contains(text.toLowerCase()));

    }
}
