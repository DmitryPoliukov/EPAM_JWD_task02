package by.epamtc.poliukov.task02.tiposervice;

import by.epamtc.poliukov.task02.entity.Ball;
import by.epamtc.poliukov.task02.entity.Basket;
import by.epamtc.poliukov.task02.entity.Color;
import by.epamtc.poliukov.task02.exception.IllegalWeightException;
import by.epamtc.poliukov.task02.printer.Printer;
import by.epamtc.poliukov.task02.reader.DataReader;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        tipoBallService tipoBallService = new tipoBallService();
        Basket basket = new Basket(10, 10000);
        Printer printer = new Printer();
        boolean isInterruptInput = false;

        try {
            while (!isInterruptInput) {
                String inputColorOrBasket = dataReader.readData();
                if (!(inputColorOrBasket.equals("basket"))) {
                    Color color = tipoBallService.analyzeColor(inputColorOrBasket);
                    double ballWeight = dataReader.readBallWeight();
                    Ball ball = new Ball(color, ballWeight);
                    basket.addBall(ball);
                    printer.printConfirmation();
                } else {
                    List<Ball> resultBalls = basket.getBallsReadOnly();
                    int blueBallsCounter = tipoBallService.blueBallsCounter(resultBalls);
                    double totalWeight = tipoBallService.totalWeightBasket(resultBalls);
                    printer.printResult(blueBallsCounter, totalWeight);
                    isInterruptInput = true;
                }
            }
        }
        catch (IllegalWeightException e){
            System.out.println(e.getMessage());

        }
    }
}
