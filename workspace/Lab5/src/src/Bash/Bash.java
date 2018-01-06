package src.Bash;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Bash {
    public Path currentDirectory;
    public StringBuffer history;

    private CommandPublisher publisher;
    private static final String EXIT = "exit";

    public Bash() {
        this.history = new StringBuffer("");
        this.currentDirectory = Paths.get(".");
        this.publisher = new BashCommandPublisher();
        // TODO 4 & 5 & 6 & 7
        // CommandSubscribers know how to execute the commands. Subscribe some to the Command publisher.
    }

	public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
        	String input = scanner.next() ;

            if (input.equals(this.EXIT){
            	return;
            }
            
            Thread t = new Thread(){
            	public void run() {
            		
            	}
            };
            t.start();
            // TODO 3 Create an anonymous class which extends Thread.
            // It has to implement the 'run' method. From the 'run' method publish the command
            // so that the CommandSubscribers start executing it.
            // Don't forget to start the thread by calling the 'start' method on it!

        }
    }

    private static class BashCommandPublisher implements CommandPublisher {

    	private ArrayList<CommandSubscriber> subscribers = new ArrayList<CommandSubscriber>();

		@Override
		public void subscribe(CommandSubscriber subscriber) {
			this.subscribers.add(subscriber);
		}

		@Override
		public void publish(Command command) {
			for(int i=0;i < this.subscribers.size();i++){			
				this.subscribers.get(i).executeCommand(command);
			}
		}
    };

}
