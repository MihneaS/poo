import java.util.Random;

public class PrintRand implements Task{
    int nr;

    PrintRand() {
        nr = (new Random()).nextInt();
    }

    @Override
    public void execute() {
        System.out.println(nr);
    }
}
