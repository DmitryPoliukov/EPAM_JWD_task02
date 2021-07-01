package by.epamtc.poliukov.task02;

import by.epamtc.poliukov.task02.entity.Ball;
import by.epamtc.poliukov.task02.entity.Basket;
import by.epamtc.poliukov.task02.entity.Color;
import by.epamtc.poliukov.task02.exception.OverVolumeCapacityException;
import by.epamtc.poliukov.task02.exception.OverWeightCapacityException;
import by.epamtc.poliukov.task02.service.BlueBallsCounterCalculator;
import by.epamtc.poliukov.task02.service.AnalysisColor;
import by.epamtc.poliukov.task02.printer.Printer;
import by.epamtc.poliukov.task02.reader.DataReader;

public class Runner {

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        AnalysisColor analysisColor = new AnalysisColor();
        BlueBallsCounterCalculator blueBallsCounterCalculator = new BlueBallsCounterCalculator();
        Basket basket = new Basket(10, 2000);
        Printer printer = new Printer();
        boolean isInterruptInput = false;

        try {
            while (!isInterruptInput) {
                String inputCharacter = dataReader.readData();
                if (!(inputCharacter.equals("basket"))
                    && !(inputCharacter.equals("remove"))) {

                    Color color = analysisColor.analyzeColor(inputCharacter);
                    double ballWeight = dataReader.readBallWeight();
                    Ball ball = new Ball(color, ballWeight);
                    basket.addBall(ball);
                    printer.printAddConfirmation(ball);
                } else if(inputCharacter.equals("remove")) {
                    String inputCharacterToRemove = dataReader.readDataToRemove();
                    Color color = analysisColor.analyzeColor(inputCharacterToRemove);
                    double ballWeight = dataReader.readBallWeight();
                    Ball removedBall = new Ball(color, ballWeight);
                    if(basket.removeBall(removedBall)) {
                        printer.printRemoveConfirmation(removedBall);
                    } else {
                        printer.noSuchBallInBasket(removedBall);
                    }
                }
                else {
                        isInterruptInput = true;
                    }
                }
            }
        catch ( OverWeightCapacityException | OverVolumeCapacityException e) {
            System.out.println(e.getMessage());
        }
        int blueBallsCounter = blueBallsCounterCalculator.blueBallsCounter(basket.getBallsIterator());
        double totalWeight = basket.calculateTotalWeightBalls();
        printer.printResult(blueBallsCounter, totalWeight);
    }
}
