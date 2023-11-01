package edu.hw2.task4;

record CallingInfo(String className, String methodName) {
}

public class Main {
    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement caller = stackTrace[2];
        String className = caller.getClassName();
        String methodName = caller.getMethodName();

        return new CallingInfo(className, methodName);
    }

    public static void main(String[] args) {
        importantMethod();
    }

    public static void importantMethod() {
        CallingInfo info = callingInfo();
        System.out.println("Caller class: " + info.className());
        System.out.println("Caller method: " + info.methodName());
    }
}
