/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

import java.util.Scanner;


public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        double legalDrivingBAC = 0.08;
        String gender = myApp.readInput("Are you male or female? ");
        String bodyWeightStr = myApp.readInput("What is your weight in pounds? ");
        String timeString = myApp.readInput("How many hours has it been since your last drink? ");
        String alcConsumedString = myApp.readInput("How many ounces of alcohol have you consumed? ");
        int alcConsumed = myApp.convertToInt(alcConsumedString);
        int bodyWeight = myApp.convertToInt(bodyWeightStr);
        int time = myApp.convertToInt(timeString);
        double BAC = myApp.calcBAC(gender, bodyWeight, time, alcConsumed);
        String outputString = myApp.generateOutputString(BAC, legalDrivingBAC);
        myApp.printOutputString(outputString);
    }

    private void printOutputString(String outputString) {
        System.out.println(outputString);
    }

    private String generateOutputString(double BAC, double legalDrivingBAC) {
        String outputString = BAC >= legalDrivingBAC
                ? String.format("Your BAC is %.02f\nIt is not legal for you to drive.", BAC)
                : String.format("Your BAC is %0.2f\nIt is legal for you to drive.", BAC);
        return outputString;
    }

    private double calcBAC(String gender, int bodyWeight, int time, int alcConsumed) {
        double maleAlcoholDistribution = 0.73;
        double femaleAlcoholDistribution = 0.66;

        if(gender.equals("male")) {
            double BAC = ((alcConsumed * 5.14) / (bodyWeight * maleAlcoholDistribution)) - 0.015 * time;
            return BAC;
        }
        double BAC = ((alcConsumed * 5.14) / (bodyWeight * femaleAlcoholDistribution)) - 0.015 * time;
        return BAC;
    }

    private int convertToInt(String str) {
        int num = Integer.parseInt(str);
        return num;
    }

    private String readInput(String str) {
        System.out.print(str);
        String input = in.nextLine();
        return input;
    }

}