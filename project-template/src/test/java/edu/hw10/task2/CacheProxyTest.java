package edu.hw10.task2;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CacheProxyTest {
    @Test
    void testCacheProxyCalculations() {
        FibCalculator fibCalculator = new PlainFibCalculator();
        FibCalculator proxy = CacheProxy.create(fibCalculator, FibCalculator.class);

        long result1 = proxy.fib(5);
        assertEquals(5, result1);

        result1 = proxy.fib(5);
        assertEquals(5, result1);

        long result2 = proxy.fib(6);
        assertEquals(8, result2);
    }

    @Test
    void testCacheFileCreation() throws IOException {
        FibCalculator fibCalculator = new PlainFibCalculator();
        FibCalculator proxy = CacheProxy.create(fibCalculator, FibCalculator.class);

        int number = 5;
        String fileName = String.format("fib[%d].txt", number);
        Path tempDir = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir"), "fib cache");
        Path filePath = tempDir.resolve(fileName);
        if (Files.exists(filePath)) {
            Files.delete(filePath);
        }

        proxy.fib(number);
        assertTrue(Files.exists(filePath));
    }

    @Test
    void testCacheProxyUseCache() {
        FibCalculator fibCalcMock = Mockito.mock(FibCalculator.class);
        when(fibCalcMock.fib(5)).thenReturn(5L);
        FibCalculator proxy = CacheProxy.create(fibCalcMock, FibCalculator.class);

        long result1 = proxy.fib(5);
        long result2 = proxy.fib(5);

        verify(fibCalcMock, times(1)).fib(5);

        assertEquals(5L, result1);
        assertEquals(5L, result2);
    }
}
