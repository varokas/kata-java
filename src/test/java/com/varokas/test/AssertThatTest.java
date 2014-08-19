package com.varokas.test;

import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AssertThatTest {
    /**
     * If you are going to use assertThat(...) always pair it with
     * the excellent hamcrest matchers library. {@linkToUrl http://mvnrepository.com/artifact/org.hamcrest/hamcrest-library}
     *
     * Since JUnit 4.11 already includes hamcrest-core, we only need hamcrest-library
     *
     * See {@linkToUrl https://code.google.com/p/hamcrest/wiki/Tutorial}
     */

    @Test
    public void assertThatIsEasyToReadFromLeftToRight() {
        int expectedValue = 2;

        assertThat(compute(), is(expectedValue));
    }

    private int compute() {
        return 2;
    }

    @Test
    public void assertThatIsExpressive() {
        int smaller = 2;
        int larger = 3;

        /* pretty isn't it? */
        assertThat(larger, is(greaterThan(smaller)));
    }

    @Ignore
    @Test
    public void assertTrueDoesNotGiveLotsOfInfoWhenFailed() {
        int smaller = 2;
        int larger = 3;

        //you'll get this message: "java.lang.AssertionError". WTH?
        assertTrue(smaller > larger);
    }

    @Ignore
    @Test
    public void assertThatGeneratesReadableErrors() {
        int smaller = 2;
        int larger = 3;

        //Gives you:
        //  java.lang.AssertionError:
        //  Expected: is a value greater than <3>
        //       but: <2> was less than <3>
        //
        // Clear, concise, effortless
        assertThat(smaller, is(greaterThan(larger)));
    }

    @Test
    public void assertThatWorksWellWithCollections() {
        List<Integer> fibonacci = Arrays.asList(1,2,3,5,8,13);

        //Don't do this, please
        boolean found = false;
        for(int i : fibonacci) {
            if( i == 5) found = true;
        }
        assertTrue( "number 5 is in list", found );

        //assertThat is way better
        assertThat(fibonacci, hasItem(5));
        assertThat(fibonacci, not(hasItem(lessThan(0))));
    }

    @Test
    public void assertThatCanBeUsedWithHamcrestMatchersLibrary() {
        //Imagine writing all these by hand...
        //
        //ps. (are you doing this everyday?)

        //String stuff
        assertThat("iGNoreMyCasePlease", equalToIgnoringCase("ignoreMyCasePlease"));
        assertThat(null, isEmptyOrNullString());

        //Math stuff
        assertThat(4, both(greaterThan(3)).and(lessThan(5)));

        //Collections Stuff
        assertThat(new ArrayList<Integer>(), is(empty()));

        assertThat(Arrays.asList(1,2,3), hasItem(1));
        assertThat(Arrays.asList(1,2,3), containsInAnyOrder(3, 1, 2)); //equalsIgnoreOrder!!
        assertThat(Arrays.asList(1,2,3), hasSize(greaterThan(0)));

        //Map Stuff
        Map<Integer, String> numbers = new HashMap<Integer, String>();
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");

        assertThat(numbers, hasEntry(1, "one"));
        assertThat(numbers, hasKey(2));
        assertThat(numbers, hasValue("three"));

        assertThat(numbers, hasKey(greaterThan(0)));
    }
}
