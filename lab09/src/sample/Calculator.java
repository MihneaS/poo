package sample;

import java.util.Collection;
import java.util.Iterator;

public class Calculator {
    int add(Integer a, Integer b) throws FlowException {
        int c = a + b;
        if (Integer.MAX_VALUE - a > b) {
            throw new OverflowException();
        }
        if (Integer.MIN_VALUE + a > b) {
            throw new UnderflowException();
        }
        return c;
    }

    int divide(Integer a, Integer b) {
        if (b == 0) {
            throw  new BadMath();
        }
        return  a/b;
    }

    int average(Collection<Integer> c) throws FlowException {
        Iterator<Integer> it = c.iterator();
        Integer s = 0;
        while(it.hasNext()) {
            s = add(it.next(), s);
        }
        return divide(s, c.size());
    }

}

class BadMath extends Error {}
class FlowException extends Exception {}
class OverflowException extends FlowException {}
class UnderflowException extends FlowException {}
