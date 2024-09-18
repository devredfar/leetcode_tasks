package com.sedykh.arrays;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalPointsTest {

    // Testing the calPoints method of the CalPoints class
    @Test
    public void testCalPoints1() {
        CalPoints calPoints = new CalPoints();
        // use case of '+' operation
        String[] operations = {"5","2","C","D","+"};
        assertEquals(30, calPoints.calPoints(operations));
    }

    @Test
    public void testCalPoints5() {
        CalPoints calPoints = new CalPoints();
        // use case of '+' operation
        String[] operations = {"5","-2","4","C","D","9","+","+"};
        assertEquals(27, calPoints.calPoints(operations));
    }

    @Test
    public void testCalPoints2() {
        CalPoints calPoints = new CalPoints();
        // use case of 'D' operation
        String[] operations = {"5","-2","D"};
        assertEquals(-1, calPoints.calPoints(operations));
    }

    @Test
    public void testCalPoints4() {
        CalPoints calPoints = new CalPoints();
        // use case with no operations
        String[] operations = {"3", "4", "5"};
        assertEquals(12, calPoints.calPoints(operations));
    }

}