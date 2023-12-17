package edu.hw10.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RandomObjectGeneratorTest {
    @Test
    public void testNextObjectByCtor() throws Exception {
        var rog = new RandomObjectGenerator();
        MyClass myClass = rog.nextObject(MyClass.class);

        assertNotNull(myClass);
        assertNull(myClass.getStringValue());
        assertTrue(myClass.getIntValue() <= 13);
        assertTrue(myClass.getIntValue() > -2);
    }

    @Test
    public void testNextObjectByFactMethod() throws Exception {
        var rog = new RandomObjectGenerator();
        MyClass myClass = rog.nextObject(MyClass.class, "create");

        assertNotNull(myClass);
        assertEquals(2, myClass.getIntValue());
        assertEquals("defString", myClass.getStringValue());
        assertEquals(-154.4, myClass.getDoubleValue());
    }

    @Test
    public void testNextObjectWithRecord() throws Exception {
        var rog = new RandomObjectGenerator();
        MyRecord myRec = rog.nextObject(MyRecord.class);

        assertNotNull(myRec);
        assertNotNull(myRec.str());
        int a = myRec.intValue();
        int b = Integer.MIN_VALUE;
        assertEquals(myRec.intValue(), Integer.MIN_VALUE);
    }
}
