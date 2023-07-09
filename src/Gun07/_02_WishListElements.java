package Gun07;

import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.WeakHashMap;

public class _02_WishListElements {

    public _02_WishListElements(){
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(css = "div[class='caption']>h4>a")
    List<WebElement> searchResult;

    @FindBy(xpath = "//button[@data-original-title='Add to Wish List']")
    List<WebElement> wishBtnList;

    @FindBy(id ="wishlist-total" )
    WebElement btnWishProducts;

    @FindBy(css = "[class='text-left']>a")
    List<WebElement> wishTableNames;

}
