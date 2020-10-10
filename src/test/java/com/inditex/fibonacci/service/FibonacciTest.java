package com.inditex.fibonacci.service;

import com.inditex.fibonacci.service.Fibonacci;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void getNegativeSequence() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(-1, fibonacci.sequence(-1));
    }

    @Test
    public void getZeroSequence() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(0, fibonacci.sequence(0));
    }

    @Test
    public void getNumberOneSequence() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(1, fibonacci.sequence(1));
    }

    @Test
    public void getPositiveFourthPositionSequence() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(3, fibonacci.sequence(4));
    }

    @Test
    public void getPositiveEighthPositionSequence() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(21, fibonacci.sequence(8));
    }
}
