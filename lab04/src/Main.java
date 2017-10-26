public class Main {
    public static void main(String[] args) {
        Container q = new Queue();
        Container s = new Stack();

        s.push(new Print("first"));
        s.push(new PrintRand());
        s.push(new PrintCount());
        q.push(new Print("secound"));
        q.push(new PrintRand());
        q.push(new PrintCount());
        s.transferFrom(q);
        while (!s.isEmpty()) {
            s.pop().execute();
        }

        AbstractTasakRunner calendar = new PrintTaskRunner(Strategy.LIFO);
        AbstractTasakRunner count = new CountTaskRunner(Strategy.LIFO);
        AbstractTasakRunner redo = new RedoTaskRunner(Strategy.LIFO);

//        calendar.addTask(new Print("thrid"));
//        calendar.addTask(new PrintCount());


    }
}
