package edu.hw2.task2;

public class Square extends Rectangle {
    public Square() {
        super(0, 0);
    }

    public Square(int side) {
        super(side, side);
    }

    Rectangle setWidth(int width) {
        return new Rectangle(width, this.height);
    }

    Rectangle setHeight(int height) {
        return new Rectangle(this.width, height);
    }

    Square setSide(int side) {
        return new Square(side);
    }
}
