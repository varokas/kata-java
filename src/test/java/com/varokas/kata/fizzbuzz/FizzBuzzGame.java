package com.varokas.kata.fizzbuzz;

public class FizzBuzzGame {
    public static String getGameString(int i) {
        if (i == 0) throw new IllegalArgumentException();

        if (i % 3 == 0 && i % 5 == 0) return "FizzBuzz";
        else if (i % 3 == 0) return "Fizz";
        else if (i % 5 == 0) return "Buzz";
        else return String.valueOf(i);
    }
}
