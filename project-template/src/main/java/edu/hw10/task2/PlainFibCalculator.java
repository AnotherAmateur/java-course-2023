package edu.hw10.task2;

public class PlainFibCalculator implements FibCalculator {
    @Override
    public long fib(int number) {
        if (number < 2) {
            return number;
        } else {
            return fib(number - 1) + fib(number - 2);
        }
    }
}
