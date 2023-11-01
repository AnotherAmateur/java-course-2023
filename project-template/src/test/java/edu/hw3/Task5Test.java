package edu.hw3;

import edu.hw3.task5.Contact;
import edu.hw3.task5.Task5;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task5Test {
    @Test
    public void testParseContactsAsc() {
        String[] names = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        Contact[] result = Task5.parseContacts(names, Task5.Order.ASC);

        assertEquals(new Contact("Thomas", "Aquinas"), result[0]);
        assertEquals(new Contact("Rene", "Descartes"), result[1]);
        assertEquals(new Contact("David", "Hume"), result[2]);
        assertEquals(new Contact("John", "Locke"), result[3]);
    }

    @Test
    public void testParseContactsDesc() {
        String[] names = {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        Contact[] result = Task5.parseContacts(names, Task5.Order.DESC);

        assertEquals(new Contact("Carl", "Gauss"), result[0]);
        assertEquals(new Contact("Leonhard", "Euler"), result[1]);
        assertEquals(new Contact("Paul", "Erdos"), result[2]);
    }

    @Test
    public void testParseContactsNoLastName() {
        String[] names = {"Paul", "Leonhard", "Carl Gauss"};
        Contact[] result = Task5.parseContacts(names, Task5.Order.ASC);

        assertEquals(new Contact("Carl", "Gauss"), result[0]);
        assertEquals(new Contact("Leonhard", null), result[1]);
        assertEquals(new Contact("Paul", null), result[2]);
    }

    @Test
    public void testParseContactsEmptyArray() {
        String[] names = {};
        Contact[] result = Task5.parseContacts(names, Task5.Order.ASC);
        assertEquals(0, result.length);
    }

    @Test
    public void testParseContactsNullArray() {
        Contact[] result = Task5.parseContacts(null, Task5.Order.ASC);
        assertEquals(0, result.length);
    }
}
