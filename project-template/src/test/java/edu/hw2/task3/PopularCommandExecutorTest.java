package edu.hw2.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

// Не представляю, как можно адекватно протестировать вероятности
public class PopularCommandExecutorTest {
    private ConnectionManager stableConnectionManager;
    private ConnectionManager faultyConnectionManager;

    @BeforeEach
    public void setup() {
        stableConnectionManager = new DefaultConnectionManager();
        faultyConnectionManager = new FaultyConnectionManager();
    }

    @Test
    public void testUpdatePackagesWithStableConnection() {
        PopularCommandExecutor executor = new PopularCommandExecutor(stableConnectionManager, 3);
        assertDoesNotThrow(() -> executor.updatePackages());
    }
}
