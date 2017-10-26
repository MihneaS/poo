public class Factory implements  IFactory {
    private static Factory inst = new Factory();

    public static Factory getInstance() {
        return inst;
    }

    public Container createContainer(Strategy strategy) {
        if (strategy == Strategy.FIFO) {
            return new Queue();
        } else if (strategy == Strategy.LIFO) {
            return new Stack();
        } else {
            return null;
        }
    }
}
