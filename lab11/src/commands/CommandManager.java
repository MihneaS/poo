package commands;

import java.util.Stack;

public class CommandManager {

    Stack<Command> todo = new Stack<>();
    Stack<Command> done = new Stack<>();

    // TODO
    /* - void undo()
       - void redo()
       - void executeCommand(Command c)
       - maybe check if undo() and redo() are available ?
             -> check GameState class, see the errors
       - keep track of the commands somehow
    */

    public void executeCommand(Command c) {
        c.execute();
        done.push(c);
    }


    public void undo() {
        if (!done.empty()) {
            Command c = done.pop();
            c.undo();
            todo.push(c);
        }
    }
    public void redo() {
        if (!todo.empty()) {
           Command c = todo.pop();
           c.execute();
           done.push(c);
        }
    }

    public boolean isUndoAvailable() {
        return !done.empty();
    }

    public boolean isRedoAvailable() {
        return !todo.empty();
    }
}
