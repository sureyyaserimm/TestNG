package Gun01;

import org.testng.annotations.*;

/*
        @BeforeClass      -->   Class ın başında çalışacak   (driver işlemleri)
           @BeforeMethod  -->   Her metoddan(test metodları) önce çalışacak
               @Test      -->   testlerin çalıştığı metodlar
               @Test      -->   testlerin çalıştığı metodlar
           @AfterMethod   -->   Her metoddan sonra çalışacak
        @AfterClass       -->   Class ın çalışmasının sonunda çalışacak (driver kapat)
     */

public class _02_Annotations {

    @BeforeClass // ->En başta çalışır. driver başlatma
    public void BeforeClass() {
        System.out.println("BeforeClass çalıştı");
    }

    @AfterClass //// ->En sonda çalışır. bekleKapat
    public void AfterClass() {
        System.out.println("AfterClass çalıştı");
    }

    @BeforeMethod // ->Her metoddan önce çalışır.
    public void BeforeMethod() {
        System.out.println("BeforeMethod çalıştı");
    }

    @AfterMethod // ->Her metoddan sonra çalışır.
    public void AfterMethod() {
        System.out.println("AfterMethod çalıştı");
    }

    @Test //test metodu
    public void test1() {
        System.out.println("test1 çalıştı");
    }

    @Test //test metodu
    public void test2() {
        System.out.println("test2 çalıştı");
    }


}
