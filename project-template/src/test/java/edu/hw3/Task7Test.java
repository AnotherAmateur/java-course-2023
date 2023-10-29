package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class Task7Test {
    @Test
    public void testTreeMapWithNullKey() {
        var tree = new TreeMap<String, String>(new Task7());
        tree.put(null, "test");

        assertTrue(tree.containsKey(null));
    }
}
