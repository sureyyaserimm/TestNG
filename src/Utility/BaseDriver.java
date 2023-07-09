package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;

    public static WebDriverWait wait;

    @BeforeClass
    public void baslangicIslemler(){

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        Duration dr = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);

        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        loginTest();

    }

    void loginTest(){
        System.out.println("Login Test");

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement inputEmail=driver.findElement(By.id("input-email"));
        inputEmail.sendKeys("anarkokomunist@marksist.com");

        WebElement password=driver.findElement(By.id("input-password"));
        password.sendKeys("0123456");

        Tools.Bekle(2);

        WebElement login=driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();
    }

    @AfterClass
    public void bitisIslemleri(){

        Tools.Bekle(3);
        driver.quit();
    }
}
