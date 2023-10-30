package edu.project1;

public final class HangmanGame {
    private final HangmanPlayer player;

    public HangmanGame(ConsolePlayer player) {
        this.player = player;
    }

    public static void main(String[] args) {
        var game = new HangmanGame(new ConsolePlayer());
        game.run();
    }

    public void run() {
        final String giveUpWord = "LOSER";
        WordsDictionary dictionary = new HangmanWordsDic();

        while (true) {
            String word = dictionary.getRandomWord();
            Session session;
            try {
                session = new Session(word);
            } catch (IllegalArgumentException exception) {
                player.displayInfo(exception.getMessage());
                return;
            }

            player.displayInfo("Let the game begin");
            player.displayInfo("Enter 'loser' to give up");
            player.displayInfo("The word: " + session.getUserAnswer());

            while (true) {
                player.displayInfo("");
                player.displayInfo("Guess a letter: ");
                String input = player.getInput().toUpperCase();

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
                    player.displayInfo("Bad input");
                }
            }

            player.displayInfo("");
            player.displayInfo("Want another game? (Y/N)");
            String input = player.getInput();
            if (Character.toUpperCase(input.charAt(0)) == 'Y') {
                continue;
            }

            return;
        }
    }

    private static GuessResult tryGuess(Session session, char guess) {
        return session.guess(guess);
    }

    private void printState(GuessResult guessRes) {
        player.displayInfo(guessRes.message());
        if (guessRes instanceof GuessResult.Win || guessRes instanceof GuessResult.Defeat) {
            return;
        }
        player.displayInfo("The word: " + String.valueOf(guessRes.state()));
        player.displayInfo("Attempts: " + guessRes.attempt() + "/" + guessRes.maxAttempts());
    }
}


