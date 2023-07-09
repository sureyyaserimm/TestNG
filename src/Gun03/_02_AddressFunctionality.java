package Gun03;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

/*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En sondan 2. adresi siliniz.
 */


public class _02_AddressFunctionality extends BaseDriver {


    @Test
    void addAddress() {

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        WebElement newAdress = driver.findElement(By.linkText("New Address"));
        newAdress.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("İsmet");

        WebElement lastname = driver.findElement(By.id("input-lastname"));
        lastname.sendKeys("Temur");

        WebElement company = driver.findElement(By.id("input-company"));
        company.sendKeys("Techno Study");

        WebElement address1 = driver.findElement(By.id("input-address-1"));
        address1.sendKeys("21a London Road");

        WebElement address2 = driver.findElement(By.id("input-address-2"));
        address2.sendKeys("RG2 5BJ");

        WebElement city = driver.findElement(By.id("input-city"));
        city.sendKeys("Reading");

        WebElement postCode = driver.findElement(By.id("input-postcode"));
        postCode.sendKeys("12345");

        // ülke seçimi tamam
        WebElement webCountry = driver.findElement(By.id("input-country"));
        Select country = new Select(webCountry);
        country.selectByVisibleText("Turkey");

        //2.seçenek
        wait.until(ExpectedConditions.elementToBeClickable(webCountry));

        //state yani şehir seçimi
        //1.seçenek
//        WebElement options=driver.findElement(By.cssSelector("select[id='input-zone']>option"));
//        wait.until(ExpectedConditions.stalenessOf(options));

        WebElement webState = driver.findElement(By.id("input-zone"));
        Select state = new Select(webState);
        //state.selectByVisibleText("Ankara");
        //state.selectByValue("3321");
        state.selectByIndex(7);
        //state element hatası : tez buldum erken kaybettim

        //selectByVisibleText, selectByValue : findElement gibi çalıştığından implicitly wait'i kullanır.
        //selectByIndex : implicitly ile çalışmıyor ancak ExplicitWait ile çalışıyor.


        WebElement defAddress = driver.findElement(By.xpath("//input[@value='1']"));
        defAddress.click();

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        Tools.successMessageValidation();

    }

    @Test(dependsOnMethods = {"addAddress"})
    void editAddress() {

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> editAll = driver.findElements(By.linkText("Edit"));
        WebElement lastEdit = editAll.get(editAll.size() - 1); // son edit
        lastEdit.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys("Sureya");

        WebElement lastname = driver.findElement(By.id("input-lastname"));
        lastname.clear();
        lastname.sendKeys("Serim");

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        Tools.successMessageValidation();
    }

    @Test(dependsOnMethods = {"editAddress"})
    void deleteAddress() {

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> editAll = driver.findElements(By.linkText("Delete"));
        WebElement deleteAddresses = editAll.get(editAll.size() - 2); // silinebilir 2.si
        deleteAddresses.click();

        Tools.successMessageValidation();
    }
}
