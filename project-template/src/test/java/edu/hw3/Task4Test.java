package edu.hw3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class Task4Test {
    @Test
    public void testConvertToRoman1() {
        String result = Task4.convertToRoman(2);
        assertEquals("II", result);
    }

    @Test
    public void testConvertToRoman2() {
        String result = Task4.convertToRoman(12);
        assertEquals("XII", result);
    }

    @Test
    public void testConvertToRoman3() {
        String result = Task4.convertToRoman(16);
        assertEquals("XVI", result);
    }

    @Test
    public void testConvertToRoman4() {
        String result = Task4.convertToRoman(3999);
        assertEquals("MMMCMXCIX", result);
    }

    @Test
    public void testConvertToRomanThrowsExc() {
        Throwable thrown = catchThrowable(() -> {
            Task4.convertToRoman(0);
        });
        assertInstanceOf(IllegalArgumentException.class, thrown);
    }
}
