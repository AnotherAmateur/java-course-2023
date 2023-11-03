package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    @Test
    public void testFreqDictStrings1() {
        List<String> input = List.of("a", "bb", "a", "bb");
        Map<String, Integer> result = Task3.freqDict(input);

        assertEquals(2, result.size());
        assertEquals(2, result.get("a"));
        assertEquals(2, result.get("bb"));
    }

    @Test
    public void testFreqDictStrings2() {
        List<String> input = List.of("код", "код", "код", "bug");
        Map<String, Integer> result = Task3.freqDict(input);

        assertEquals(2, result.size());
        assertEquals(3, result.get("код"));
        assertEquals(1, result.get("bug"));
    }

    @Test
    public void testFreqDictIntegers() {
        List<Integer> input = List.of(1, 1, 2, 2);
        Map<Integer, Integer> result = Task3.freqDict(input);

        assertEquals(2, result.size());
        assertEquals(2, result.get(1));
        assertEquals(2, result.get(2));
    }

    @Test
    public void testFreqDictObjects() {
        List<Object> input = List.of("a", 1, "a", 2, "a", "1");
        Map<Object, Integer> result = Task3.freqDict(input);

        assertEquals(4, result.size());
        assertEquals(3, result.get("a"));
        assertEquals(1, result.get(1));
        assertEquals(1, result.get(2));
        assertEquals(1, result.get("1"));
    }

    @Test
    public void testFreqDictEmpty() {
        List<String> input = List.of();
        Map<String, Integer> result = Task3.freqDict(input);

        assertEquals(0, result.size());
    }
}
