package edu.project1;

import org.jetbrains.annotations.NotNull;

public class Session {
    public final String rightAnswer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    public Session(String answer) throws IllegalArgumentException {
        checkIsWordValid(answer);

        this.rightAnswer = answer;
        this.maxAttempts = 5;
        this.attempts = 0;
        this.userAnswer = new char[answer.length()];
        for (int i = 0; i < answer.length(); i++) {
            userAnswer[i] = '_';
        }
    }

    @NotNull
    GuessResult guess(char guess) {
        boolean found = false;

        for (int i = 0; i < rightAnswer.length(); i++) {
            if (rightAnswer.charAt(i) == guess) {
                userAnswer[i] = guess;
                found = true;
            }
        }

        if (found) {
            if (String.valueOf(userAnswer).equals(rightAnswer)) {
                return new GuessResult.Win(userAnswer, attempts, maxAttempts,
                    "The right answer was: " + rightAnswer
                );
            } else {
                return new GuessResult.SuccessfulGuess(userAnswer, attempts, maxAttempts, "Ok");
            }
        } else {
            attempts++;
            if (attempts >= maxAttempts) {
                return new GuessResult.Defeat(
                    rightAnswer.toCharArray(), attempts, maxAttempts,
                    "You lost. The right answer was: " + rightAnswer
                );
            } else {
                return new GuessResult.FailedGuess(userAnswer, attempts, maxAttempts, "Wrong");
            }
        }
    }

    @NotNull
    GuessResult giveUp() {
        return new GuessResult.Defeat(
            rightAnswer.toCharArray(), attempts, maxAttempts,
            "You gave up. The right answer was: " + rightAnswer
        );
    }

    public String getUserAnswer() {
        return String.valueOf(userAnswer);
    }

    private void checkIsWordValid(String word) throws IllegalArgumentException {
        if (word.length() < 5 || word.length() > 30) {
            throw new IllegalArgumentException();
        }
    }
}
