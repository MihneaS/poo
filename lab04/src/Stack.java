import java.util.List;
import java.util.ArrayList;

public class Stack implements Container {

    List<Task> list = new ArrayList<Task>();

    @Override
    public Task pop() {
        if (!isEmpty()) {
            return list.remove(list.size() - 1);
        } else {
            return  null;
        }
    }

    @Override
    public void push(Task task) {
        list.add(task);

    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void transferFrom(Container container) {
        while (!container.isEmpty()) {
            push(container.pop());
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
