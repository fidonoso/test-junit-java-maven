package com.actividad2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        // int result = calculator.add(2, 3);
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(-1, 1));
        assertEquals(-2, calculator.add(-1, -1));
        assertEquals(7, calculator.add(7, 0));
    }

    @Test
    public void testSustract() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.subtract(5, 2));
        assertEquals(-3, calculator.subtract(2, 5));
        assertEquals(-7, calculator.subtract(-2, 5));
        assertEquals(7, calculator.subtract(2, -5));
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        assertEquals(8, calculator.multiply(4, 2));
        assertEquals(-8, calculator.multiply(4, -2));
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.divide(4, 2));
    }


    @Test
    public void testDivideByZero() {
        Calculator calculator = new Calculator();
        try {
            calculator.divide(1, 0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Division by zero", e.getMessage());
        }
    }

}
