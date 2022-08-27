package lesson_7;

import lesson_7.testclass.MyTestingClass;
import lesson_7.testclass.annotations.AfterSuite;
import lesson_7.testclass.annotations.BeforeSuite;
import lesson_7.testclass.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        test(Class.forName("lesson_7.testclass.MyTestingClass"));
    }

    public static void test(Class<?> testClass) throws InstantiationException, IllegalAccessException, InvocationTargetException {

        List<Method> testMethodList = getMethodsWithAnnotation(Test.class, testClass);
        List<Method> beforeMethodList = getMethodsWithAnnotation(BeforeSuite.class, testClass);
        List<Method> afterMethodList = getMethodsWithAnnotation(AfterSuite.class, testClass);

        MyTestingClass myTestingClass = (MyTestingClass) testClass.newInstance();

        testMethodList.sort((Comparator.comparingInt(o -> o.getAnnotation(Test.class).priority())));

        System.out.println();
        System.out.println("Начинаем обработку!");
        System.out.println();

        checkBeforeAndAfter(beforeMethodList, "@BeforeSuite");
        checkBeforeAndAfter(afterMethodList, "@AfterSuite");
        invoke(beforeMethodList, myTestingClass);
        invoke(testMethodList, myTestingClass);
        invoke(afterMethodList, myTestingClass);

    }

    static  List<Method> getMethodsWithAnnotation(Class<? extends Annotation> annotation, Class<?> tClass) {
        Method[] declaredMethods = tClass.getDeclaredMethods();
        return Arrays.stream(declaredMethods).filter(o -> o.getAnnotation(annotation) != null).collect(Collectors.toList());
    }

    static void checkBeforeAndAfter(List<Method> methodList, String annoName) {
        if (methodList.isEmpty()) {
            System.out.printf("Метод с аннотацией %s не найден. Продолжаем работу%n", annoName);
        } else if (methodList.size() > 1) {
            StringBuilder sb = new StringBuilder();
            methodList.forEach(o -> sb.append(o.getName()).append(" "));
            throw new UnsupportedOperationException(String.format("Присутствует более одного метода с аннотацией %s: %s%n ", annoName,  sb));
        }
    }

    static <T> void invoke(List<Method> methodList, T tClass) throws InvocationTargetException, IllegalAccessException {
        for (Method method : methodList) {
            if (method.getModifiers() != Modifier.PUBLIC) {
                method.setAccessible(true);
            }
            System.out.printf("Вызываем метод [%s] с аннотацией[%s] - ", method.getName(), method.getAnnotations()[0].annotationType().getSimpleName());
            method.invoke(tClass);
        }
    }
}
