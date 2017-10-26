public class CountTaskRunner extends AbstractTasakRunner {

    PrintCount pCount = new PrintCount();

    CountTaskRunner(Strategy strategy) {
        super(strategy);
    }

    @Override
    protected void abstractTask(Task task) {
        pCount.execute();
    }
}
