package by.epamtc.poliukov.task02.logic;

import by.epamtc.poliukov.task02.entity.Ball;
import by.epamtc.poliukov.task02.entity.Color;

import java.util.List;

public class Logic {

    public Color analyzeColor(String color) {
        switch (color) {
            case "r":
                return Color.RED;
            case "b":
                return Color.BLUE;
            case "w":
                return Color.WHITE;
            default:
                return Color.GREEN;
        }
    }

    public int blueBallsCounter(List<Ball> basket) {
        int blueBallsCounter = 0;
        for(Ball ball: basket) {
            if(ball.getColor().equals(Color.BLUE)){
                blueBallsCounter++;
            }
        }
        return blueBallsCounter;
    }

}
