package lesson7.TestAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        runTest(TestClass.class);
    }

    public static void runTest(Class c) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = c.getDeclaredMethods();
        List<Method> methodList = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                int priority = method.getAnnotation(Test.class).priority();
                if (priority < 1 || priority > 10) {
                    throw new RuntimeException("Illigal prority");
                }
                methodList.add(method);
            }
        }
        methodList.sort((o1, o2) -> o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority());

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (methodList.get(0).isAnnotationPresent(BeforeSuite.class)) {
                    throw new RuntimeException("More then one BeforeSuite method");
                }
                methodList.add(0, method);
            }

            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (methodList.get(methodList.size() - 1).isAnnotationPresent(AfterSuite.class)) {
                    throw new RuntimeException("More then one AfterSuite method");
                }
                methodList.add(method);
            }
        }

        for (Method method : methodList) {
            method.invoke(null);
        }
    }
}
