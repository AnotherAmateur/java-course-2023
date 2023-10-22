package edu.project1;

import org.jetbrains.annotations.NotNull;

public class Session {
    public final String RIGHT_ANSWER;
    private final char[] USER_ANSWER;
    private final int MAX_ATTEMPTS;
    private int attempts;

    public Session(String answer) throws IllegalArgumentException {
        checkIsWordValid(answer);

        this.RIGHT_ANSWER = answer;
        this.MAX_ATTEMPTS = 5;
        this.attempts = 0;
        this.USER_ANSWER = new char[answer.length()];
        for (int i = 0; i < answer.length(); i++) {
            USER_ANSWER[i] = '_';
        }
    }

    @NotNull
    public GuessResult guess(char guess) {
        boolean found = false;

        for (int i = 0; i < RIGHT_ANSWER.length(); i++) {
            if (RIGHT_ANSWER.charAt(i) == guess) {
                USER_ANSWER[i] = guess;
                found = true;
            }
        }

        if (found) {
            if (String.valueOf(USER_ANSWER).equals(RIGHT_ANSWER)) {
                return new GuessResult.Win(USER_ANSWER, attempts, MAX_ATTEMPTS,
                    "The right answer was: " + RIGHT_ANSWER
                );
            } else {
                return new GuessResult.SuccessfulGuess(USER_ANSWER, attempts, MAX_ATTEMPTS, "Ok");
            }
        } else {
            attempts++;
            if (attempts >= MAX_ATTEMPTS) {
                return new GuessResult.Defeat(RIGHT_ANSWER.toCharArray(), attempts, MAX_ATTEMPTS,
                    "You lost. The right answer was: " + RIGHT_ANSWER
                );
            } else {
                return new GuessResult.FailedGuess(USER_ANSWER, attempts, MAX_ATTEMPTS, "Wrong");
            }
        }
    }

    @NotNull
    public GuessResult giveUp() {
        return new GuessResult.Defeat(RIGHT_ANSWER.toCharArray(), attempts, MAX_ATTEMPTS,
            "You gave up. The right answer was: " + RIGHT_ANSWER
        );
    }

    public String getUserAnswer() {
        return String.valueOf(USER_ANSWER);
    }

    private void checkIsWordValid(String word) throws IllegalArgumentException {
        if (word.length() < 5 || word.length() > 30) {
            throw new IllegalArgumentException();
        }
    }
}
