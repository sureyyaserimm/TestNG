package Gun03;

import Utility.BaseDriver;
import org.testng.annotations.Test;

public class _01_Dependency extends BaseDriver {
    // arabanın hareketi : start, drive, park, stop hareket sırası

    @Test
    void startCar() {
        System.out.println("startCar");
        //Assert.fail();
    }

    @Test(dependsOnMethods = {"startCar"})
// bu testin çalışması, startCar ın hatasız çalışmasına bağımlı
    void driveCar() {
        System.out.println("driveCar");
    }

    @Test(dependsOnMethods = {"startCar", "driveCar"})
    void parkCar() {
        System.out.println("parkCar");
    }

    //alwaysRun = true bağımlılıkları var ama hata çıkarsa da yine çalıştır
    @Test(dependsOnMethods = {"parkCar"}, alwaysRun = true)
    void stopCar() {
        System.out.println("stopCar");
    }

    // aynı seviyedeki testleri için priority verilebilir.
    // bağımlı testler, direk metodundan çalıştırdığınızda bağımlı olduğu metod zincirinde
    // 2 üste kadar ototmatik çağırıp çalışabilir.

}

