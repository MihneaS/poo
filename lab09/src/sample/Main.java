package sample;



public class Main {

    public static void main(String[] args) {



        try {
            ErrGen.genOutOfMemoryError();
            ErrGen.genStackOverflowError();
        } catch (OutOfMemoryError e) {
            e.fillInStackTrace();
        } catch (StackOverflowError e) {
            e.fillInStackTrace();
        }
    }
}
