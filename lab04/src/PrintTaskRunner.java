import java.util.Calendar;

public class PrintTaskRunner extends AbstractTasakRunner {

    PrintTaskRunner(Strategy strategy) {
        super(strategy);
    }

    @Override
    public void abstractTask(Task task) {
        System.out.println(Calendar.getInstance().toString());
    }


}
