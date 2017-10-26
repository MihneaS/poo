import java.util.ArrayList;
import java.util.List;

public class Queue  implements Container{

    List<Task> list = new ArrayList<Task>();

    @Override
    public Task pop() {
        if (!isEmpty()) {
            return list.remove(0);
        } else {
            return null;
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
            list.add(container.pop());
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
