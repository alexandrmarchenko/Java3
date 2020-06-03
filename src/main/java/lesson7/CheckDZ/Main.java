package lesson7.CheckDZ;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        checkHW();
    }

    private static void checkHW() throws NoSuchMethodException, MalformedURLException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        File file = new File("D:/123");
        String[] str = file.list();
        if(str != null) {
            for (String o : str) {
                String[] mass = o.split("\\.");
                if (!mass[1].equalsIgnoreCase("class")) {
                    throw new RuntimeException(o, new Exception());
                }
                String fileName = mass[0];

                boolean res = checkClass(fileName);

            }
        }
    }

    private static boolean checkClass(String name) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("CLASS: " + name);
        Class check = URLClassLoader.newInstance(new URL[]{new File("D:/123").toURL()}).loadClass(name);
        Constructor constructor = check.getConstructor();
        Object checkCalculate = constructor.newInstance();

        boolean test1 = testCalculate(check, checkCalculate);
        System.out.println("Method testCalculate test result: " + test1);
        boolean test2 = testCheckTwoNumbers(check, checkCalculate);
        System.out.println("Method testCheckTwoNumbers test result: " + test2);
        boolean test3 = testIsNegative(check, checkCalculate);
        System.out.println("Method isNegative test result: " + test3);
        boolean test4 = testIsLeapYear(check, checkCalculate);
        System.out.println("Method isLeapYear test result: " + test4);
        boolean res = test1 && test2 && test3 && test4;
        System.out.println("CLASS TEST RESULT: " + res);
        return res;
    }

    private static boolean testCalculate(Class check, Object checkCalculate) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        int[][] test = new int[][]{
                {1, 2, 3, 4, 2},
                {1, -1, 1, -1, -2},
                {-1, -2, -3, -4, 2}
        };
        Method m = check.getDeclaredMethod("calculate", int.class, int.class, int.class, int.class);
        for (int i = 0; i < test.length; i++) {
            int res = (int) m.invoke(checkCalculate, test[i][0], test[i][1], test[i][2], test[i][3]);
            if (res != test[i][4]) {
                return false;
            }
        }
        return true;
    }

    private static boolean testCheckTwoNumbers(Class check, Object checkCalculate) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object[][] test = new Object[][]{
                {new int[]{1, 2}, false},
                {new int[]{10, 2}, true},
                {new int[]{15, -10}, false},
                {new int[]{5, 5}, true},
                {new int[]{10, 10}, true}
        };
        Method m = check.getDeclaredMethod("checkTwoNumbers", int.class, int.class);

        for (int i = 0; i < test.length; i++) {
            int[] fields = (int[]) test[i][0];
            boolean res = (boolean) m.invoke(checkCalculate, fields[0], fields[1]);
            if (res != (boolean) test[i][1]) {
                return false;
            }
        }

        return true;
    }

    private static boolean testIsNegative(Class check, Object checkCalculate) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object[][] test = new Object[][]{
                {1, false},
                {0, false},
                {-1, true}
        };
        Method m = check.getDeclaredMethod("isNegative", int.class);
        for (int i = 0; i < test.length; i++) {
            boolean res = (boolean) m.invoke(checkCalculate, test[i][0]);
            if (res != (boolean) test[i][1]) {
                return false;
            }
        }

        return true;
    }

    private static boolean testIsLeapYear(Class check, Object checkCalculate) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object[][] test = new Object[][]{
                {2020, true},
                {2019, false},
                {2016, true}
        };
        Method m = check.getDeclaredMethod("isLeapYear", int.class);
        for (int i = 0; i < test.length; i++) {
            boolean res = (boolean) m.invoke(checkCalculate, test[i][0]);
            if (res != (boolean) test[i][1]) {
                return false;
            }
        }

        return true;
    }
}
