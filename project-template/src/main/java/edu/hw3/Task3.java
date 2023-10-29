package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
    public static <T> Map<T, Integer> freqDict(List<T> objectList) {
        var freqHMap = new HashMap<T, Integer>();

        for (T item : objectList) {
            freqHMap.put(item, freqHMap.getOrDefault(item, 0) + 1);
        }

        return freqHMap;
    }
}
