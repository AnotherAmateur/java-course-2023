package edu.hw3;

import org.jetbrains.annotations.NotNull;
import java.util.HashMap;
import java.util.Map;

public class Task1 {
    private char[] alphabetSorted;
    private Map<Character, Integer> alpabetIndexed;
    private final int alpabetSize;

    public Task1(@NotNull char[] alphabetSorted) {
        this.alphabetSorted = alphabetSorted;
        this.alpabetSize = alphabetSorted.length;
        this.alpabetIndexed = getAlpabetIndexed(alphabetSorted);
    }

    public String encodeAtbash(String str) {
        var result = new StringBuilder();

        for (int i = 0; i < str.length(); ++i) {
            char letter = str.charAt(i);
            char letterNorm = Character.toLowerCase(letter);
            if (alpabetIndexed.containsKey(letterNorm)) {
                char letterTmp = alphabetSorted[alpabetSize - alpabetIndexed.get(letterNorm) - 1];
                letter = Character.isLowerCase(letter) ?
                    Character.toLowerCase(letterTmp) :
                    Character.toUpperCase(letterTmp);
            }
            result.append(letter);
        }
        return result.toString();
    }

    private Map<Character, Integer> getAlpabetIndexed(char[] alphabetSorted) {
        var alpabetIndexed = new HashMap<Character, Integer>();

        for (int i = 0; i < alpabetSize; ++i) {
            alpabetIndexed.put(Character.toLowerCase(alphabetSorted[i]), i);
        }
        return alpabetIndexed;
    }
}
