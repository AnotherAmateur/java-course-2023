package edu.hw3;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class Task1 {
    private final String alphabetSorted;
    private final Map<Character, Integer> alpabetIndexed;
    private final int alpabetSize;

    public Task1(@NotNull String alphabetSorted) {
        this.alphabetSorted = alphabetSorted;
        this.alpabetSize = alphabetSorted.length();
        this.alpabetIndexed = getAlpabetIndexed(alphabetSorted);
    }

    // Алгоритм работает для любого алфавита, неправильного или выдуманного
    // Единственное требование - буквы в переданном алфавите должны находиться в правильном,
    // с точки зрения пользователя, порядке
    public String encodeAtbash(String str) {
        var result = new StringBuilder();

        for (int i = 0; i < str.length(); ++i) {
            char letter = str.charAt(i);
            char letterNorm = Character.toLowerCase(letter);
            if (alpabetIndexed.containsKey(letterNorm)) {
                char letterTmp = alphabetSorted.charAt(alpabetSize - alpabetIndexed.get(letterNorm) - 1);
                letter = Character.isLowerCase(letter)
                    ? Character.toLowerCase(letterTmp)
                    : Character.toUpperCase(letterTmp);
            }
            result.append(letter);
        }
        return result.toString();
    }

    private Map<Character, Integer> getAlpabetIndexed(String alphabetSorted) {
        var alpabetIndexed = new HashMap<Character, Integer>();

        for (int i = 0; i < alpabetSize; ++i) {
            alpabetIndexed.put(Character.toLowerCase(alphabetSorted.charAt(i)), i);
        }
        return alpabetIndexed;
    }

    public static String generateCustomAlphabet(char startChar, char endChar) {
        var alphabet = new StringBuilder(endChar - startChar + 1);
        for (int i = 0, j = endChar - startChar; i <= j; ++i) {
            alphabet.append((char) (startChar + i));
        }
        return alphabet.toString();
    }

    public static String getEnAlphabet() {
        return generateCustomAlphabet('a', 'z');
    }
}
