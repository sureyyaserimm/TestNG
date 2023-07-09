package TestingProject_5.Utility;

import Utility.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParameters {
    public WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    @Parameters("browser")
    public void baslangicIslemler(String browser){

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);


        if (browser.equalsIgnoreCase("firefox")){
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            driver  =   new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }
        else if (browser.equalsIgnoreCase("edge")){
            driver  =   new EdgeDriver();
        }


        driver.manage().window().maximize(); // Ekranı max yapıyor.
        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);


        driver.get("https://admin-demo.nopcommerce.com/admin/");

    }

    @AfterClass
    public void bitisIslemleri(){
        Tools.Bekle(3);
        driver.quit();
    }
}
