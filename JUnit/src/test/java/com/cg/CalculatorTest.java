package com.cg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void calTest(){
        Calculator cal = new Calculator();
        assertEquals(10, cal.calculate(7,3));
    }
    @Test
     public void isPrimeTest(){
        Calculator cal = new Calculator();
        assertTrue(cal.isPrime(13));
        assertFalse(cal.isPrime(1));
        assertFalse(cal.isPrime(20));

}
}
