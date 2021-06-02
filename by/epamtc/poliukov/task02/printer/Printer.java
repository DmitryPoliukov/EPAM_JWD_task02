package by.epamtc.poliukov.task02.printer;

import by.epamtc.poliukov.task02.entity.Ball;

public class Printer {
    public void printResult(int blueBallsCounter, double totalWeightBasket){
        System.out.printf("Amount of blue balls - %d, total weight of balls in basket - %.1f", blueBallsCounter,totalWeightBasket);
    }

    public void printConfirmation(Ball ball){
        System.out.println(ball.toString() + " was added to basket");
    }
}
