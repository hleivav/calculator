package org.example;
import java.util.Scanner;

public class Main {
    static boolean done = false;
    static double partialResult = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        print("Welcome to the console-based calculator!");

        do {
            menuCreator();
            choiceHandler();
        } while (!done);
    }

    public static void menuCreator(){

        String [] optionArray = {"Exit", "Addition", "Subtraction", "Multiplication", "Division"};

        print("Choose the number for the operation you want to perform: ");
            for (int i = 0; i < optionArray.length; i++) {
                print(i + " - " + optionArray[i]);
        }
    }

    public static void choiceHandler(){
        String userChoice = scanner.nextLine();
        //In case the user enters a none numeric character, the application will catch it.
        try {
            double firstNo = 0;
            double secondNo = 0;
            int choice = Integer.parseInt(userChoice);
            if (userChoice.equals("0")){
                done = true;
            } else if (Integer.parseInt(userChoice) > 0 && Integer.parseInt(userChoice) < 5) {
                while (true){
                    try {
                        print("Enter the first number: ");
                        firstNo = Double.parseDouble(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        print("Invalid input. Please enter a number.");
                    }
                }
                while (true){
                    try {
                        print("Enter the second number: ");
                        secondNo = Double.parseDouble(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        print("Invalid input. Please enter a number.");
                    }
                }
                partialResult = operation(userChoice, firstNo, secondNo);
                print("The final result is " + partialResult);
            } else {
                print("Incorrect choice. Try again!");
            }
        } catch (NumberFormatException e) {
            print("Invalid input. Please enter a number.");
        }

    }

    public static double operation(String operationNumber, double firstNumber, double secondNumber){
        String operationString = "";
        switch (operationNumber){
            case "1":
                partialResult = firstNumber + secondNumber;
                operationString = "addition";
                break;
            case "2":
                partialResult = firstNumber - secondNumber;
                operationString = "subtraction";
                break;
            case "3":
                partialResult = firstNumber * secondNumber;
                operationString = "multiplication";
                break;
            case "4":
                partialResult = firstNumber / secondNumber;
                operationString = "division";
                break;
        }
        print("The partial result is " + partialResult);
        print("Do you need to perform another " + operationString + " on this result? Press Y in that case or another key to resume.");
        //This input is secure. The user can choose between y, Y or anything else.
        if (scanner.nextLine().equalsIgnoreCase("Y")){
            print("Enter a new number to perform a new " + operationString);
            try {
                double  newNumber = Double.parseDouble(scanner.nextLine());
                partialResult = operation(operationNumber, partialResult, newNumber);
            } catch (NumberFormatException e) {
                print("Invalid input. Please enter a number.");
            }

        }
        return partialResult;
    }

    public static void print(String stringToPrint){
        System.out.println(stringToPrint);
    }

    public static void print(Double doubleToPrint){
        System.out.println(doubleToPrint);
    }
}