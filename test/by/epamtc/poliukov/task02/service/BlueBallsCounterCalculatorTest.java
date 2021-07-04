package by.epamtc.poliukov.task02.service;

import by.epamtc.poliukov.task02.entity.Ball;
import by.epamtc.poliukov.task02.entity.Color;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class BlueBallsCounterCalculatorTest {
    BlueBallsCounterCalculator calculator = new BlueBallsCounterCalculator();

    @Test
    public void blueBallsCounter() {
        List<Ball> ballsTest = new ArrayList<>();
        {
            ballsTest.add(new Ball(Color.BLUE, 10));
            ballsTest.add(new Ball(Color.BLUE, 20));
            ballsTest.add(new Ball(Color.RED, 10));
            ballsTest.add(new Ball(Color.GREEN, 80));
        }
        Iterator<Ball> ballIterator = ballsTest.iterator();

        int expected = 2;
        int actual = calculator.blueBallsCounter(ballIterator);
        assertEquals(expected, actual);

    }
}