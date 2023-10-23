package edu.hw2.Task4;

record CallingInfo(String className, String methodName) {
}

public class Main {
    public static CallingInfo callingInfo() {
        String className = "";
        String methodName = "";

        try {
            var a = new double[999999999];
        } catch (Throwable ex) {
            var stackTrace = ex.getStackTrace()[1];
            className = stackTrace.getClassName();
            methodName = stackTrace.getMethodName();
        }

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
