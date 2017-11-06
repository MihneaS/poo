package bash;

import java.nio.file.Files;

enum Commands {
    CD("cd"),
    LS("ls"),
    ECHO("echo"),
    HISTORY("history");

    private final String text;

    Commands(final String newText) {
        this.text = newText;
    }

    @Override
    public String toString() {
        return text;
    }
}

public class BashUtils {

    // Implement some inner classes here: Echo, Cd, Ls, History

    // example: class Cd { ... }

    // Decide if they should be static or non-static.

    // TODO 4 Create Echo class
    static class Echo implements CommandSubscriber {

        @Override
        public void executeCommand(Command c) {
            String firstWord = Bash.firstWord(c.getCommand());
            if (firstWord.equals("echo")) {
                System.out.println(c.getCommand().substring(5));
            }
        }
    }

    // TODO 5 Create Cd class
    static class Cd implements CommandSubscriber {

        @Override
        public void executeCommand(Command c) {
            String firstWord = Bash.firstWord(c.getCommand());
            if (firstWord.equals("cd")) {

            }
        }
    }

    // TODO 6 Create the Ls class
    static class Ls implements CommandSubscriber {

        @Override
        public void executeCommand(Command c) {
            String firstWord = Bash.firstWord(c.getCommand());
            if (firstWord.equals("ls")) {
                System.
            }
        }
    }

    // TODO 7 Create the History class
}
