public class RedoTaskRunner extends AbstractTasakRunner {

    private Container stack = Factory.getInstance().createContainer(Strategy.FIFO);

    RedoTaskRunner(Strategy strategy) {
        super(strategy);
    }

    @Override
    protected void abstractTask(Task task) {
       stack.push(task);
    }

    public void redo() {
        while (!stack.isEmpty()){
            stack.pop().execute();
        }
    }
}
