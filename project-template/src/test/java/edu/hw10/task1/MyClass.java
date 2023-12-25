package edu.hw10.task1;

class MyClass {
    private int intValue;

    private String stringValue;

    private double doubleValue;

    public int getIntValue() {
        return intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    private MyClass(@Min(-2) @Max(13) int intValue,  String stringValue, @Max(-4586.0) double doubleValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
        this.doubleValue = doubleValue;
    }

    public static MyClass create() {
        return new MyClass(2, "defString", -154.4);
    }
}
