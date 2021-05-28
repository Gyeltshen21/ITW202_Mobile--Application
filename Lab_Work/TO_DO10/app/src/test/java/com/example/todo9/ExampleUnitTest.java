package com.example.todo9;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class ExampleUnitTest {
    Calculator mCalculator;

    @Before
    public void setUp(){
       mCalculator = new Calculator();
    }

    @Test
    public void addTwoNumbers(){
        double result = mCalculator.Add(1d,3d);
        assertThat(result,is(equalTo(4)));
    }

    @Test
    public void addTwoNumbersNegative(){
        double result = mCalculator.Add(-1d,3d);
        assertThat(result,is(equalTo(2.0)));
    }
    @Test
    public void subTwoNumbers(){
        double result = mCalculator.Sub(1d,3d);
        assertThat(result,is(equalTo(-2.0)));
    }

    @Test
    public void subWorksWithNegativeResults(){
        double result = mCalculator.Sub(-1d,-3d);
        assertThat(result,is(equalTo(2.0)));
    }

    @Test
    public void mulTwoNumbers() {
        double result = mCalculator.Mult(-1d,-3d);
        assertThat(result,is(equalTo(3.0)));
    }
    @Test
    public void mulTwoNumbersZero(){
        double result = mCalculator.Mult(0d,0d);
        assertThat(result,is(equalTo(0.0)));
    }
    @Test
    public void divTwoNumbers() {
        double result = mCalculator.Div(5d,5d);
        assertThat(result,is(equalTo(1.0)));
    }
    @Test
    public void divTwoNumbersZero(){
        double result = mCalculator.Div(3d,0d);
        assertEquals("Divide by zero gives infinity as result", true, Double.isInfinite(result));
    }

}