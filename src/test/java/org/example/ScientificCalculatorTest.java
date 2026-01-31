package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScientificCalculatorTest {
    
    private ScientificCalculator calculator;

    @Before
    public void setUp() {
        calculator = new ScientificCalculator();
    }

    @Test
    public void testSquareRootValid() {
        assertEquals(2.0, calculator.squareRoot(4.0), 0.0001);
        assertEquals(3.0, calculator.squareRoot(9.0), 0.0001);
        assertEquals(1.4142, calculator.squareRoot(2.0), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSquareRootInvalid() {
        calculator.squareRoot(-1.0);
    }

    @Test
    public void testFactorialValid() {
        assertEquals(1, calculator.factorial(0));
        assertEquals(1, calculator.factorial(1));
        assertEquals(2, calculator.factorial(2));
        assertEquals(6, calculator.factorial(3));
        assertEquals(24, calculator.factorial(4));
        assertEquals(120, calculator.factorial(5));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testFactorialInvalid() {
        calculator.factorial(-1);
    }
    
    @Test
    public void testNaturalLogValid() {
        assertEquals(0.0, calculator.naturalLog(1.0), 0.0001);
        assertEquals(1.0, calculator.naturalLog(Math.E), 0.0001);
        assertEquals(1.6094, calculator.naturalLog(5.0), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNaturalLogInvalid() {
        calculator.naturalLog(0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNaturalLogNegative() {
        calculator.naturalLog(-1.0);
    }
    
    @Test
    public void testPower() {
        assertEquals(4.0, calculator.power(2.0, 2.0), 0.0001);
        assertEquals(8.0, calculator.power(2.0, 3.0), 0.0001);
        assertEquals(9.0, calculator.power(3.0, 2.0), 0.0001);
        assertEquals(0.25, calculator.power(2.0, -2.0), 0.0001);
        assertEquals(1.0, calculator.power(5.0, 0.0), 0.0001);
    }
}