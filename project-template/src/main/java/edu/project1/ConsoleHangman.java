package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

final class ConsoleHangman {
    private static final Logger LOGGER = LogManager.getLogger();

    private ConsoleHangman() {
    }

//    public static void main(String[] args) {
//        run();
//    }

    public static void run() {
        final String giveUpWord = "LOSER";
        WordsDictionary dictionary = new HangmanWordsDic();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String word = dictionary.getRandomWord();
            Session session;
            try {
                session = new Session(word);
            } catch (IllegalArgumentException exception) {
                LOGGER.info(exception.getMessage());
                return;
            }

            LOGGER.info("Let the game begin");
            LOGGER.info("Enter 'loser' to give up");
            LOGGER.info("The word: " + session.getUserAnswer());

            while (true) {
                LOGGER.info("");
                LOGGER.info("Guess a letter: ");
                String input = scanner.nextLine().toUpperCase();

                if (input.equals(giveUpWord)) {
                    GuessResult guessRes = session.giveUp();
                    printState(guessRes);
                    break;
                } else if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                    char guess = input.charAt(0);
                    GuessResult guessRes = tryGuess(session, guess);
                    printState(guessRes);

                    if (guessRes instanceof GuessResult.Win || guessRes instanceof GuessResult.Defeat) {
                        break;
                    }
                } else {
                    LOGGER.info("Bad input");
                }
            }

            LOGGER.info("");
            LOGGER.info("Want another game? (Y/N)");
            String input = scanner.nextLine();
            if (Character.toUpperCase(input.charAt(0)) == 'Y') {
                continue;
            }

            scanner.close();
            return;
        }
    }

    private static GuessResult tryGuess(Session session, char guess) {
        return session.guess(guess);
    }

    private static void printState(GuessResult guessRes) {
        LOGGER.info(guessRes.message());

        if (guessRes instanceof GuessResult.Win || guessRes instanceof GuessResult.Defeat) {
            return;
        }

        LOGGER.info("The word: " + String.valueOf(guessRes.state()));
        LOGGER.info("Attempts: " + guessRes.attempt() + "/" + guessRes.maxAttempts());
    }
}


