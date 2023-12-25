package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class Task7Test {
    @Test
    public void testTreeMapWithNullKey() {
        var tree = new TreeMap<String, String>(Comparator.nullsFirst(
            Comparator.comparing(key -> key))
        );
        tree.put(null, "test");

        assertTrue(tree.containsKey(null));
    }
}
