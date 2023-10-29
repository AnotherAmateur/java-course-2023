package edu.hw3;

import java.util.Arrays;
import java.util.Comparator;

public class Task5 {
    private Task5() {
    }

    public enum Order {
        ASC,
        DESC
    }

    public static Object[] parseContacts(String[] names, Order order) {
        if (names == null || names.length == 0) {
            return new Object[0];
        }

        var comparator = new NamesComparator(order);
        return Arrays.stream(names).sorted(comparator).toArray(Object[]::new);
    }

    static private class NamesComparator implements Comparator<String> {
        Order order;

        private NamesComparator(Order order) {
            this.order = order;
        }

        @Override
        public int compare(String str1, String str2) {
            String[] name1 = str1.split(" ");
            String[] name2 = str2.split(" ");

            return switch (order) {
                case DESC -> {
                    if (name1.length == 2 && name2.length == 2) {
                        yield name2[1].compareTo(name1[1]);
                    }
                    yield name2[0].compareTo(name1[0]);
                }
                case ASC -> {
                    if (name1.length == 2 && name2.length == 2) {
                        yield name1[1].compareTo(name2[1]);
                    }
                    yield name1[0].compareTo(name2[0]);
                }
            };
        }
    }
}
