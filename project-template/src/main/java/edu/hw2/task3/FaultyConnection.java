package edu.hw2.task3;

public class FaultyConnection implements Connection {
    @Override
    public void execute(String command) {
        final double PROBABILITY = 0.5;
        if (Math.random() < PROBABILITY) {
            throw new ConnectionException("Connection failed");
        }
    }

    @Override
    public void close() {
    }
}
