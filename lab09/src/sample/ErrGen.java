package sample;

import java.util.ArrayList;

public class ErrGen {

    static void genOutOfMemoryError() {//throws OutOfMemoryError {
        ArrayList<Integer> list = new ArrayList<>(Integer.MAX_VALUE);
        //throw new OutOfMemoryError();
    }

    static void genStackOverflowError() {//throws StackOverflowError {
        genStackOverflowError();
        //StackOverflowError up = new StackOverflowError();
        //throw up;
    }

}
