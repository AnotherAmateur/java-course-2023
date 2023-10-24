package edu.hw2.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {
    Rectangle rect;

    @BeforeEach
    void setUp() {
        rect = new Rectangle(5, 6);
    }

    @Test
    public void testRectangleCtor() {
        assertEquals(5, rect.width);
        assertEquals(6, rect.height);
    }

    @Test
    public void testRectangleArea() {
        assertEquals(30, rect.area());
    }

    @Test
    public void testRectangleSetWidth() {
        Rectangle newRectangle = rect.setWidth(8);
        assertEquals(8, newRectangle.width);
        assertEquals(6, newRectangle.height);
    }

    @Test
    public void testRectangleSetHeight() {
        Rectangle newRect = rect.setHeight(10);
        assertEquals(5, newRect.width);
        assertEquals(10, newRect.height);
    }
}
