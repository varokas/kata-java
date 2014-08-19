package com.varokas.kata.fizzbuzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    @Test
    public void testCaseThree() {
        assertEquals("Fizz", FizzBuzzGame.getGameString(3));
    }

    @Test
    public void testCaseDividedByThree() {
        assertEquals("Fizz", FizzBuzzGame.getGameString(6));
    }

    @Test
    public void testCaseFive() {
        assertEquals("Buzz", FizzBuzzGame.getGameString(5));
    }

    @Test
    public void testCaseDividedByFive() {
        assertEquals("Buzz", FizzBuzzGame.getGameString(20));
    }

    @Test
    public void testCaseThreeAndFive() {
        assertEquals("FizzBuzz", FizzBuzzGame.getGameString(15));
    }

    @Test
    public void testCaseOne() {
        assertEquals("1", FizzBuzzGame.getGameString(1));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testCaseZero() {
        FizzBuzzGame.getGameString(0);
    }
}
