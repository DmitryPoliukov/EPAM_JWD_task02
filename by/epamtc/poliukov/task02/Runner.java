package by.epamtc.poliukov.task02;

import by.epamtc.poliukov.task02.entity.Ball;
import by.epamtc.poliukov.task02.entity.Basket;
import by.epamtc.poliukov.task02.entity.Color;
import by.epamtc.poliukov.task02.exception.IllegalWeightException;
import by.epamtc.poliukov.task02.exception.OverVolumeCapacityException;
import by.epamtc.poliukov.task02.exception.OverWeightCapacityException;
import by.epamtc.poliukov.task02.logic.Logic;
import by.epamtc.poliukov.task02.printer.Printer;
import by.epamtc.poliukov.task02.reader.DataReader;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        Logic logic = new Logic();
        Basket basket = new Basket(10, 2000);
        Printer printer = new Printer();
        boolean isInterruptInput = false;

        try {
            while (!isInterruptInput) {
                String inputColorOrBasket = dataReader.readData();
                if (!(inputColorOrBasket.equals("basket"))) {
                    Color color = logic.analyzeColor(inputColorOrBasket);
                    double ballWeight = dataReader.readBallWeight();
                    Ball ball = new Ball(color, ballWeight);
                    basket.addBall(ball);
                    printer.printConfirmation(ball);
                } else {
                    isInterruptInput = true;
                }
            }
        }
        catch (IllegalWeightException | OverWeightCapacityException | OverVolumeCapacityException e) {
            System.out.println(e.getMessage());
        }
        finally {
            List<Ball> resultBalls = basket.getBallsReadOnly();
            int blueBallsCounter = logic.blueBallsCounter(resultBalls);
            double totalWeight = basket.getTotalWeightBalls();
            printer.printResult(blueBallsCounter, totalWeight);
        }
    }
}
