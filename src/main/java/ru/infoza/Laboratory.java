package main.java.ru.infoza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Laboratory {
//    public static void main(String[] args) {
//        System.out.println(getCallerClassAndMethodName());
//        method();
////        anotherMethod();
//
//    }

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        m1();    }

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());    }

    private static void method() {
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if(stackTraceElements.length > 3) {
            StackTraceElement element = stackTraceElements[3];
            String className = element.getClassName();
            String methodName = element.getMethodName();
            return className + "#" + methodName;
        }
        return null; // your implementation here
    }

    public static void collections(){
        Collection<?> collection = new ArrayList<>();
        Object object = new Object();
//        Object object = new int[3];
        System.out.println(collection.size());
        System.out.println(collection.toArray());
        collection.clear();
//        collection.addAll(Arrays.asList(object));
        collection.remove(object);
        collection.iterator();
        collection.contains(object);
//        collection.add(object);
    }

}