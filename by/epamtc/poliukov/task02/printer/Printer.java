package by.epamtc.poliukov.task02.printer;

public class Printer {
    public void printResult(int blueBallsCounter, double totalWeightBasket){
        System.out.printf("Quantity of blue balls - %d, total weight of balls in basket - %.1f", blueBallsCounter,totalWeightBasket);
    }

    public void printConfirmation(){
        System.out.println("Ball was added to basket");
    }
}
