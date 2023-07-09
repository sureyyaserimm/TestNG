package Gun04;

import org.testng.annotations.*;

public class _01_Intro {

    /*
     @BeforeSuite
       @BeforeTest
         @BeforeGroup
           @BeforeClass
             @BeforeMethod
                 @Test1 method
                 @Test2 method
             @AfterMethod
           @AfterClass
         @AfterGroup
       @AfterTest
     @AfterSuite
   */

    @BeforeSuite
    void bSuite(){
        System.out.println("Before Suite");
    }

    @BeforeTest
    void bTest(){
        System.out.println("Before Test");
    }

    @BeforeGroups
    void bGroups(){
        System.out.println("Before Groups");
    }

    @BeforeClass
    void bClass(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    void bMethod(){
        System.out.println("Before Method");
    }

    @Test
    void Intro1_Test1(){
        System.out.println("Intro_1 -> Test1");
    }

    @Test
    void Intro2_Test2(){
        System.out.println("Intro_1 -> Test2");
    }

    @AfterMethod
    void aMethod(){
        System.out.println("After Method");
    }

    @AfterClass
    void aClass(){
        System.out.println("After Class");
    }

    @AfterGroups
    void aGroups(){
        System.out.println("After Groups");
    }

    @AfterTest
    void aTest(){
        System.out.println("After Test");
    }

    @AfterSuite
    void aSuite(){
        System.out.println("After Suite");
    }

}
