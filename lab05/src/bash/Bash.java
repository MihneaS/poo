package bash;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Bash {
    public static Path currentDirectory;
    private StringBuffer history;

    private CommandPublisher publisher;
    private static final String EXIT = "exit";

    private static Bash instance;
    private static BashUtils.Echo echo;

    public static Bash getInstance() {
        return instance;
    }

    public Bash() {
        instance = this;
        echo = new BashUtils.Echo();

        // TODO 2 Initialize history and currentDirectory;
         history = new StringBuffer();
         currentDirectory = Paths.get("").toAbsolutePath();

        // TODO 2 Instantiate a new command publisher
         publisher = new BashCommandPublisher();

         publisher.subscribe(echo);

        // TODO 4 & 5 & 6 & 7
        // CommandSubscribers know how to execute the commands.
        // Subscribe some to the Command publisher.
    }

    // Method that returns the first word
    public static String firstWord(String input) {
        return input.split(" ")[0]; // Create array of words and return the 0th word
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // TODO 3 Read commands from the command line
            String line = scanner.nextLine();
            String firstWord = firstWord(line);
            // TODO 3 If we read the "exit" string then we should stop the program.
            if (firstWord.equals("exit")) {
                return;
            }

            // TODO 3 Create an anonymous class which extends Thread.
            // It has to implement the 'run' method. From the 'run' method publish the command
            // so that the CommandSubscribers start executing it.
            // Don't forget to start the thread by calling the 'start' method on it!
            Thread t = new Thread() {
                public void run () {
                    publisher.publish(new Command(line, Bash.getInstance()));
                }
            };
            t.start();

        }
    }

    // TODO 1: Create an inner class which implements the CommandPublisher interface.
    // 1. The class should contain an ArrayList of CommandSubscribers
    // 2. The class should implement the subscribe and publish methods.
    class BashCommandPublisher implements CommandPublisher {

        List<CommandSubscriber> subscribers = new ArrayList<>();

        @Override
        public void subscribe(CommandSubscriber subscriber) {
            subscribers.add(subscriber);
        }

        @Override
        public void publish(Command command) {
            for (CommandSubscriber subscriber: subscribers) {
                subscriber.executeCommand(command);
            }
        }
    }

}
