package Fibonacci;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainTest {

Main testedObject;

    @org.junit.Before
    public void setUp() throws Exception {
        testedObject = new Main();
    }

    @org.junit.Test
    public void calculateNumber() {
        int result = testedObject.calculateNumber(2);
        assertEquals(1, result);
    }

    @org.junit.Test
    public void createArray() {
        ArrayList <Integer> testArray = new ArrayList<>();
        testArray = testedObject.createArray(5);
        assertEquals(6, testArray.size());
    }
}