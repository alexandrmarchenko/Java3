package lesson7.TestAnnotation;

public class TestClass {
    @BeforeSuite
    public static void start() {
        System.out.println("start");
    }

    @Test(priority = 3)
    public static void method1() {
        System.out.println("Test method1");
    }

    @Test(priority = 1)
    public static void method2() {
        System.out.println("Test method2");
    }

    @Test(priority = 7)
    public static void method3() {
        System.out.println("Test method3");
    }

    @Test
    public static void method4() {
        System.out.println("Test method4");
    }

    @AfterSuite
    public static void shutdown() {
        System.out.println("shutdown");
    }

}
