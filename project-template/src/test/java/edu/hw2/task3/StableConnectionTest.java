package edu.hw2.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class StableConnectionTest {
    private Connection connection;

    @BeforeEach
    public void setup() {
        connection = new StableConnection();
    }

    @Test
    public void testExecute1() {
        assertDoesNotThrow(() -> connection.execute("help"));
    }

    @Test
    public void testExecute2() {
        assertDoesNotThrow(() -> connection.execute("help"));
    }

    @Test
    public void testExecute3() {
        assertDoesNotThrow(() -> connection.execute("help"));
    }
}
