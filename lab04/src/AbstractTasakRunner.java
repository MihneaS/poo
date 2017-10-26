public abstract class AbstractTasakRunner {
    Container container;

    AbstractTasakRunner(Strategy strategy) {
        container = Factory.getInstance().createContainer(strategy);
    }

    public void addTask(Task task) {
        container.push(task);
    }

    public void executeAll() {
        while(container.isEmpty()) {
            Task task = container.pop();
            task.execute();
            abstractTask(task);
        }
    }

    protected abstract void abstractTask(Task task);

}
