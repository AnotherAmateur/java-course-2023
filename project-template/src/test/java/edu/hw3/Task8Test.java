package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task8Test {
    @Test
    public void testHasNext() {
        var numbers = Arrays.asList(1, 2, 3);
        var iterator = new Task8<Integer>(numbers);

        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testNext() {
        var numbers = Arrays.asList(1, 2, 3);
        var iterator = new Task8<Integer>(numbers);

        assertEquals(3, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(1, iterator.next());
    }
}
