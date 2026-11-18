package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testSum() {
        assertEquals(10, calculator.sum(5, 5));
    }

    @Test
    void testDivide() {
        assertEquals(5, calculator.divide(10, 2));
    }

    @Test
    void testDivideByZero() {
        assertThrows(
            IllegalArgumentException.class,
            () -> calculator.divide(10, 0)
        );
    }
}
