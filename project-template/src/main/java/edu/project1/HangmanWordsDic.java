package edu.project1;

import org.jetbrains.annotations.NotNull;

public class HangmanWordsDic implements WordsDictionary {
    private final String[] words = {
        "TINKOFF",
        "WATERMELON",
        "MANATEE",
        "APPLE"
    };

    @NotNull
    public String getRandomWord() {
        int randomIndex = (int) (Math.random() * words.length);
        return words[randomIndex];
    }
}
