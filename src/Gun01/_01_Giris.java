package Gun01;


import org.testng.annotations.Test;

public class _01_Giris {

//        webSitesiniAc();
//        LoginIsleminiYap();
//        driveriKapat();
//    }

//    @Test JUnit
//    public void Test1(){
//        webSitesiniAc();
//        LoginIsleminiYap();
//        driveriKapat();
//    }


    //eğer herhangi bir sıralama verilmeze metod isimlerinin alfabetik sırasıyla çalışıyor.
    // @Test'ten sonra parantez içine priority yazıp hangisini kaçıncı sırada çalışacağna karar veriyoruz.

    @Test(priority = 1) //default0 : index gibi düşünebiliriz.
    public void webSitesiniAc() {
        System.out.println("driver tanımlandı ve WebSitesiAcildi");
    }

    @Test(priority = 2)
    public void loginIsleminiYap() {
        System.out.println("LoginTest işlemi yapıldı");
    }

    @Test(priority = 3)
    public void driveriKapat() {
        System.out.println("driver kapatıldı");
    }

}
