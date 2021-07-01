package by.epamtc.poliukov.task02.service;

import by.epamtc.poliukov.task02.entity.Ball;
import by.epamtc.poliukov.task02.entity.Color;

import java.util.Iterator;

public class BlueBallsCounterCalculator {

    public int blueBallsCounter(Iterator<Ball> ballsIterator) {
        int blueBallsCounter = 0;
        while (ballsIterator.hasNext()) {
            Ball nextBall = ballsIterator.next();
            if (nextBall.getColor() == Color.BLUE) {
                ++blueBallsCounter;
            }
        }
        return blueBallsCounter;
    }
}
