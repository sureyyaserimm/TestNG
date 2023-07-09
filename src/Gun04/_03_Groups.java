package Gun04;

import org.testng.annotations.Test;

public class _03_Groups {

    @Test(groups = {"Smoke Test"})
    void test1(){System.out.println("test1"); }

    @Test(groups = {"Regression Test"})
    void test3(){System.out.println("test3"); }

    @Test(groups = {"Regression Test"})
    void test5(){System.out.println("test5"); }

    @Test(groups = {"Regression Test"})
    void test2(){System.out.println("test2"); }

    @Test(groups = {"Smoke Test"})
    void test4(){System.out.println("test4"); }

    @Test(groups = {"Smoke Test"})
    void test6(){System.out.println("test6"); }

    @Test
    void test7(){System.out.println("test7"); }
}
