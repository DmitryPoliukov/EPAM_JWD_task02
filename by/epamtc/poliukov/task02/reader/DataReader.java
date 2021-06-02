package by.epamtc.poliukov.task02.reader;

import by.epamtc.poliukov.task02.exception.IllegalWeightException;

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
                " r - red,\n b - blue,\n w - white, \n g - green \n" +
                "basket - return data about filling the basket");
        switch (inputData = stringScanner.nextLine()) {
            case "r":
            case "b":
            case "w":
            case "g":
            case "basket":
                return inputData;
            default:
                System.out.println("Incorrect input");
                return readData();
        }
    }

    public double readBallWeight() throws IllegalWeightException {
        boolean isCorrectWeight = false;
        double inputWeight = 0;
        while (!isCorrectWeight) {
            System.out.println("Enter ball weight in grams");
            inputWeight = doubleScanner();
            if (inputWeight <= 0) {
                throw new IllegalWeightException("Weight must be greater than zero");
            } else {
                isCorrectWeight = true;
            }
        }
        return inputWeight;
    }
        
}
