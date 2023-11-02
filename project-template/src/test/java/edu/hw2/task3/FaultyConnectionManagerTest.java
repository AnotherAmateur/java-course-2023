package edu.hw2.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class FaultyConnectionManagerTest {
    private ConnectionManager connectionManager;

    @BeforeEach
    public void setup() {
        connectionManager = new FaultyConnectionManager();
    }

    @Test
    public void testGetConnection1() {
        assertInstanceOf(FaultyConnection.class, connectionManager.getConnection());
    }

    @Test
    public void testGetConnection2() {
        assertInstanceOf(FaultyConnection.class, connectionManager.getConnection());
    }

    @Test
    public void testGetConnection3() {
        assertInstanceOf(FaultyConnection.class, connectionManager.getConnection());
    }
}
