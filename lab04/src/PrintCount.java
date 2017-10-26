public class PrintCount implements Task {

    public static int count = 0;

    @Override
    public void execute() {
        System.out.println(count++);
    }
}
