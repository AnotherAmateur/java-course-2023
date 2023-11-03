package edu.hw3;

import java.util.LinkedHashMap;

public class Task4 {
    private Task4() {
    }

    public static String convertToRoman(int num) throws IllegalArgumentException {
        if (num < 1 || num > 3999) {
            throw new IllegalArgumentException();
        }

        var romanToArabicDecr = new LinkedHashMap<String, Integer>();
        romanToArabicDecr.put("M", 1000);
        romanToArabicDecr.put("CM", 900);
        romanToArabicDecr.put("D", 500);
        romanToArabicDecr.put("CD", 400);
        romanToArabicDecr.put("C", 100);
        romanToArabicDecr.put("XC", 90);
        romanToArabicDecr.put("L", 50);
        romanToArabicDecr.put("XL", 40);
        romanToArabicDecr.put("X", 10);
        romanToArabicDecr.put("IX", 9);
        romanToArabicDecr.put("V", 5);
        romanToArabicDecr.put("IV", 4);
        romanToArabicDecr.put("I", 1);

        StringBuilder romanRes = new StringBuilder();

        for (String symbol : romanToArabicDecr.keySet()) {
            while (num >= romanToArabicDecr.get(symbol)) {
                romanRes.append(symbol);
                num -= romanToArabicDecr.get(symbol);
            }
        }

        return romanRes.toString();
    }
}
