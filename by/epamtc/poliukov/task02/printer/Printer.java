package by.epamtc.poliukov.task02.printer;

import by.epamtc.poliukov.task02.entity.Ball;

/**
 * The Class Printer print messages to console.
 *
 * @author Dmitry Poliukov
 */
public class Printer {
    public void printResult(int blueBallsCounter, double totalWeightBasket) {
        System.out.printf("Amount of blue balls - %d, total weight of balls in basket - %.1f", blueBallsCounter,totalWeightBasket);
    }

    public void printAddConfirmation(Ball ball) {
        System.out.println(ball.toString() + " was added to basket");
    }

    public void printRemoveConfirmation(Ball ball) {
        System.out.println(ball.toString() + " was removed from the basket");
    }

    public void noSuchBallInBasket(Ball ball) {
        System.out.println("There is no " + ball.toString() + " in the basket");
    }
}
