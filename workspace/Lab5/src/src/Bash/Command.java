package src.Bash;

public class Command {
    private Bash bash;
    private String command;

    public Command(String command, Bash bash) {
        this.bash = bash;
        this.command = command;
    }

    public Bash getBash() {
        return bash;
    }

    public String getCommand() {
        return command;
    }
}
