package edu.hw3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task5Test {
    @Test
    public void testParseContactsAsc() {
        String[] names = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        Object[] result = Task5.parseContacts(names, Task5.Order.ASC);
        assertEquals("Thomas Aquinas", result[0]);
        assertEquals("Rene Descartes", result[1]);
        assertEquals("David Hume", result[2]);
        assertEquals("John Locke", result[3]);
    }

    @Test
    public void testParseContactsDesc() {
        String[] names = {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        Object[] result = Task5.parseContacts(names, Task5.Order.DESC);
        assertEquals("Carl Gauss", result[0]);
        assertEquals("Leonhard Euler", result[1]);
        assertEquals("Paul Erdos", result[2]);
    }

    @Test
    public void testParseContactsNoLastName() {
        String[] names = {"Paul", "Leonhard", "Carl Gauss"};
        Object[] result = Task5.parseContacts(names, Task5.Order.ASC);
        assertEquals("Carl Gauss", result[0]);
        assertEquals("Leonhard", result[1]);
        assertEquals("Paul", result[2]);
    }

    @Test
    public void testParseContactsEmptyArray() {
        String[] names = {};
        Object[] result = Task5.parseContacts(names, Task5.Order.ASC);
        assertEquals(0, result.length);
    }

    @Test
    public void testParseContactsNullArray() {
        Object[] result = Task5.parseContacts(null, Task5.Order.ASC);
        assertEquals(0, result.length);
    }
}
