package edu.hw2.task2;

public class Rectangle {
    protected final int width;
    protected final int height;

    public Rectangle() {
        this.width = 0;
        this.height = 0;
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    Rectangle setWidth(int width) {
        return new Rectangle(width, this.height);
    }

    Rectangle setHeight(int height) {
        return new Rectangle(this.width, height);
    }

    double area() {
        return width * height;
    }
}
