package org.example;
import java.util.Scanner;

public class Main {
    static boolean done = false;
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

        if (userChoice.equals("0")){
            done = true; 
        } else if (Integer.parseInt(userChoice) > 0 && Integer.parseInt(userChoice) < 5) {
            print("The result is: " + operation(userChoice));

        } else {
            print("Incorrect choice. Try again!");
        }
    }

    public static double operation(String operationNumber){
        print("Enter the first number: ");
        double firstNumber = Double.parseDouble(scanner.nextLine());
        print("Enter the second number: ");
        double secondNumber = Double.parseDouble(scanner.nextLine());
        double result = 0;
        switch (operationNumber){
            case "1":
                result = firstNumber + secondNumber;
                break;
            case "2":
                result = firstNumber - secondNumber;
                break;
            case "3":
                result = firstNumber * secondNumber;
                break;
            case "4":
                result = firstNumber / secondNumber;
                break;
        }
        return result;
    }

    public static void print(String stringToPrint){
        System.out.println(stringToPrint);
    }

    public static void print(Double doubleToPrint){
        System.out.println(doubleToPrint);
    }
}