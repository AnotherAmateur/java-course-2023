package edu.hw3.task5;

import java.util.Arrays;
import java.util.Comparator;

public class Task5 {
    private Task5() {
    }

    public enum Order {
        ASC,
        DESC
    }

    public static Contact[] parseContacts(String[] names, Order order) {
        if (names == null || names.length == 0) {
            return new Contact[0];
        }

        return Arrays.stream(names)
            .map(str -> stringContactConverter(str))
            .sorted((order == Order.ASC) ? ASC : DESC)
            .toArray(Contact[]::new);
    }

    private static Contact stringContactConverter(String name) throws IllegalArgumentException {
        String[] nameSplit = name.split(" ");
        return switch (nameSplit.length) {
            case 1 -> new Contact(nameSplit[0], null);
            case 2 -> new Contact(nameSplit[0], nameSplit[1]);
            default -> throw new IllegalArgumentException();
        };
    }

    private static final Comparator<Contact> ASC = Comparator
        .comparing(Contact::lastName, Comparator.nullsLast(Comparator.naturalOrder()))
        .thenComparing(Contact::firstName, Comparator.nullsLast(Comparator.naturalOrder()));

    private static final Comparator<Contact> DESC = ASC.reversed();
}
