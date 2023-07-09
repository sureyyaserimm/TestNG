package TestingProject_5;


import TestingProject_5.Utility.BaseDriver;
import Utility.Tools;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ProjectFiveDOM extends BaseDriver {
    public ProjectFiveDOM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @Test
    public void loginTest() {
        ProjectFive object = new ProjectFive();
        object.mail.clear();
        object.passwords.clear();
        object.mail.sendKeys("admin@yourstore.com");
        object.passwords.sendKeys("admin");
        object.Login.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
    }

    @Test(dependsOnMethods = "loginTest")
    public void leftNavMenu() {

        for (int i = 9; i >= 1; i--) {
            List<WebElement> baslik = driver.findElements(By.xpath("(//nav[@class='mt-2']/ul/li[@class='nav-item has-treeview']/a)[" + i + "]"));
            for (WebElement b : baslik) {
                b.click();
            }
            Assert.assertTrue(baslik.size() != 0);
        }
    }

    @Test(dependsOnMethods = "loginTest")
    void createCustomer() {
        ProjectFive object = new ProjectFive();
        object.baslik.click();
        object.subMenu.click();
        object.addNew.click();
        object.email.sendKeys("sureya2@gmail.com");
        object.Password.sendKeys("a1b2c3d4f5g6");
        object.FirstName.sendKeys("Süreya");
        object.LastName.sendKeys("Serim");
        object.gender.click();
        object.DateOfBirth.sendKeys("3/22/2000");
        object.Company.sendKeys("MyCompany LTD.ŞTİ.");
        object.IsTaxExempt.click();
        Select VendorMenu = new Select(object.VendorId);
        VendorMenu.selectByVisibleText("Vendor 1");
        object.content.sendKeys("Güzel bir proje bayağı da kolaymış teşekkürler!");
        object.saveBtn.click();
        Assert.assertTrue(object.assertMessage.getText().contains("successfully"));
    }

    @Test(dependsOnMethods = "loginTest")
    void editCustomer() {
        ProjectFive object = new ProjectFive();
        object.baslik.click();
        object.subMenu.click();
        object.SearchEmails.sendKeys("sureya2@gmail.com");
        object.SearchFirstName.sendKeys("Süreya");
        object.SearchLastName.sendKeys("Serim");
        object.searchBtn.click();
        Assert.assertTrue(object.searchMail.getText().contains(object.SearchEmails.getText()));
        object.editBtn.click();
        object.EditFirstName.clear();
        object.EditFirstName.sendKeys("Derya");
        object.saveBtn.click();
        Assert.assertTrue(object.assertMessage.getText().contains("successfully"));
    }

    @Test(dependsOnMethods = "loginTest")
    void deleteCustomer() {
        ProjectFive object = new ProjectFive();
        object.baslik.click();
        Tools.Bekle(2);
        object.subMenu.click();
        object.SearchEmails.sendKeys("sureya2@gmail.com");
        object.SearchFirstName.sendKeys("Derya");
        object.SearchLastName.sendKeys("Serim");
        object.searchBtn.click();
        object.editBtn.click();
        object.delete.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-danger float-right']")));
        object.confirmDelete.click();
        Assert.assertTrue(object.assertMessage.getText().contains("deleted"));
    }

    @Test(dependsOnMethods = "loginTest")
    void searchTest() {
        ProjectFive object      =   new ProjectFive();
        object.searchInput.click();
        object.searchInput.sendKeys("Shipments");
        object.searchSub.click();
        Assert.assertTrue(object.result.getText().contains("Shipments"));
    }
}
