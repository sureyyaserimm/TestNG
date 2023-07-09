package Gun07;

import Gun06._03_PlaceOrderElements;
import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

/*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
   3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
 */

public class _01_WishListPOM extends BaseDriver {

    @Test
    @Parameters("searchText")
    void AddToWishList(String text){

        _03_PlaceOrderElements poe=new _03_PlaceOrderElements();

        poe.searchBox.sendKeys(text);
        poe.searchButton.click();

        _02_WishListElements wle=new _02_WishListElements();

        int randomSecim= Tools.RandomGenerator(wle.searchResult.size()); // 0,1,2,3
        String wishItemText=wle.searchResult.get(randomSecim).getText(); // tıklatılacak elemanın ismini aldım
        wle.wishBtnList.get(randomSecim).click(); // random elementin wish listine tıklattım
        wle.btnWishProducts.click();
        Tools.listContainsString(wle.wishTableNames, wishItemText);




    }


}
