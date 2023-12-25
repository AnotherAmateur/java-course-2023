package edu.hw2.task3;

public class DefaultConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        final double PROBABILITY = 0.5;
        return Math.random() < PROBABILITY ? new StableConnection() : new FaultyConnection();
    }
}
