package TestingProject_5.Utility;


import Utility.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;


    public static WebDriverWait wait;

    @BeforeClass
    public void baslangicIslemler(){
        // gerekmeyen log ları kaldıracağız.
        // önce ayar kodu girilecek sonra calıştırılacak

        Logger logger= Logger.getLogger(""); // output a ait bütün logları üreten objeye/servise ulaştım ""
        logger.setLevel(Level.SEVERE); // Sadece errorları göster

        // sout kısmı ayar kısmı oluyor.
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        // driver kısmı ise ayarlanan kısım

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);





        Duration dr=Duration.ofSeconds(15);
        driver.manage().timeouts().pageLoadTimeout(dr);
        // Sadece tüm sayfanın kodlarının bilgisyarınıza inmesi süresiyle ilgili
        // bu eklenmezse Selenium sayfa yüklenene kadar (sonsuza) bekler.:
        // 30 sn süresince sayfanın yüklenmesini bekle yüklenmezse hata ver
        // eğer 2 sn yüklerse 30 sn. beklemez.
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(dr);
        // Bütün weblementlerin element bazında, elemente özel işlem yapılmadan önce
        // hazır hale gelmesi verilen mühlet yani süre. // eğer 2 sn yüklerse 30 sn. beklemez.

        wait = new WebDriverWait(driver,
                Duration.ofSeconds(30));

        driver.get("https://admin-demo.nopcommerce.com/admin/");

    }

        //Assert.assertEquals(driver.getTitle(),"My Account", "Login olamadı");
        //Assert.assertTrue(driver.getCurrentUrl().contains("account/account"));


//        public static void KalanOncekileriKapat() {
//
//        try {
//            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
//        } catch (Exception ignored) {
//
//        }
//    }


    public static void BekleKapat()
    {
        Tools.Bekle(2);
        driver.quit();
    }


    public void bitisIslemleri() {
        Tools.Bekle(5);
        driver.quit();
    }
}
