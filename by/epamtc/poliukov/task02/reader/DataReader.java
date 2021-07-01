package by.epamtc.poliukov.task02.reader;

import by.epamtc.poliukov.task02.entity.Color;

import java.util.Scanner;

public class DataReader {
    Scanner stringScanner = new Scanner(System.in);

    public static double doubleScanner() {
        Scanner doubleScanner = new Scanner(System.in);
        while(!doubleScanner.hasNextDouble()) {
            System.out.println("Incorrect input");
            doubleScanner.next();
        }
        return doubleScanner.nextDouble();
    }

    public String readData() {
        String inputData;
        System.out.println("Enter the color of ball to add to basket \n" +
                " r - red,\n b - blue,\n w - white, \n g - green " +
                "\n remove - remove the ball from the basket" +
                "\n basket - return data about filling the basket");
        switch (inputData = stringScanner.nextLine()) {
            case "r":
            case "b":
            case "w":
            case "g":
            case "basket":
            case "remove":
                return inputData;
            default:
                System.out.println("Incorrect input");
                return readData();
        }
    }

    public double readBallWeight() {
        boolean isCorrectWeight = false;
        double inputWeight = 0;
        while (!isCorrectWeight) {
            System.out.println("Enter ball weight in grams");
            inputWeight = doubleScanner();
            if (inputWeight <= 0) {
                System.out.println("Weight must be greater than zero");
            } else {
                isCorrectWeight = true;
            }
        }
        return inputWeight;
    }

    public String readDataToRemove() {
        String inputDataToRemove;
        System.out.println("Enter the color of ball to remove ball from basket \n" +
                " r - red,\n b - blue,\n w - white, \n g - green ");
        switch (inputDataToRemove = stringScanner.nextLine()) {
            case "r":
            case "b":
            case "w":
            case "g":
                return inputDataToRemove;
            default:
                System.out.println("Incorrect input");
                return readData();
        }
    }

        
}
