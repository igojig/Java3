package lesson_7.testclass;

import lesson_7.testclass.annotations.AfterSuite;
import lesson_7.testclass.annotations.BeforeSuite;
import lesson_7.testclass.annotations.Test;

public class MyTestingClass {

    //    public MyTestingClass() {
//    }

    @Test(priority = 10)
    void m10() {
        System.out.println("Метод 10");
    }

    @Test
    void m0() {
        System.out.println("Метод 0");
    }

    @Test(priority = 9)
    void m9() {
        System.out.println("Метод 9");
    }

    @Test(priority = 8)
    void m8() {
        System.out.println("Метод 8");
    }
    @Test(priority = 8)
    void m8_1() {
        System.out.println("Метод 8_1");
    }

    @Test(priority = 7)
    void m7() {
        System.out.println("Метод 7");
    }

    @Test(priority = 1)
    void m1() {
        System.out.println("Метод 1");
    }

    @Test(priority = 4)
    private void m4() {
        System.out.println("Метод 4");
    }

    @BeforeSuite
    void before() {
        System.out.println("Самый первый метод");
    }

//        @BeforeSuite
    void before1() {
        System.out.println("Самый первый второй метод");
    }

//    @AfterSuite
    void after() {
        System.out.println("Самый последный метод");
    }

//    @AfterSuite
    void after1() {
        System.out.println("Самый последный второй метод");
    }

}
