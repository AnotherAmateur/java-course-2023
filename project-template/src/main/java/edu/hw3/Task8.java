package edu.hw3;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Task8<T> implements Iterator<T> {
    private final List<T> elements;
    private int currentPosition;

    public Task8(Collection<T> collection) {
        this.elements = List.copyOf(collection);
        this.currentPosition = elements.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return currentPosition >= 0;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return elements.get(currentPosition--);
    }
}
