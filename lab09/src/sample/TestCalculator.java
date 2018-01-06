package sample;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.util.LinkedList;

public class TestCalculator {
    private Calculator calc;

    @Before
    public void setup() {
        calc = new Calculator();
    }

    @org.junit.Test
    public void testOverFlow() {
        try {
            calc.add(10, Integer.MAX_VALUE);
        } catch (FlowException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void testUnderFlow() {
        try {
            calc.add(-10, Integer.MIN_VALUE);
        } catch (FlowException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        calc = null;
    }

}


