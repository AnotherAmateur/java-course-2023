package edu.hw10.task2;

public class PlainFibCalculator implements FibCalculator {
    @Override public long fib(int number) {
        return (number < 2) ? number : fib(number - 1) + fib(number - 2);
    }
}
