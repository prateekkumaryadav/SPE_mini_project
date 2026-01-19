package org.example;

import java.util.*;
//import java.util.Scanner;
//import java.util.InputMismatchException;

public class Main {
    private Scanner scanner;

    // constructor
    public Main() {
        scanner = new Scanner(System.in);
    }

    // square root function
    public double squareRoot(double num) {
        if (num < 0) { // negative number checking
            throw new IllegalArgumentException("Cannot compute square root of a negative number");
        }
        return Math.sqrt(num);
    }

    // handle square root function
    private void handleSquareRoot() {
        System.out.print("Enter the number to calculate the square root of: ");

        try { // try-catch block for exception handling
            double num = scanner.nextDouble();
            double sqrt = squareRoot(num);
            System.out.println("Square root of " + num + " is " + sqrt);
        } catch (InputMismatchException e) {
            System.out.println("Enter a valid number to calculate the square root!");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // factorial function
    public long factorial(int num) {
        if (num < 0) { // negative number checking
            throw new IllegalArgumentException("Cannot compute the factorial of a negative number");
        }
        long fact = 1;
        for (int i = 2; i <= num; i++){
            fact *= i;
        }
        return fact;
    }

    // handle factorial function
    private void handleFactorial() {
        System.out.print("Enter the number to calculate the factorial of: ");

        try { // try-catch block for exception handling
            int num = scanner.nextInt();
            long fact = factorial(num);
            System.out.println("Factorial of " + num + " is " + fact);
        } catch (InputMismatchException e) {
            System.out.println("Enter a valid number to calculate the factorial!");
            scanner.nextLine(); // move to the next line
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // natural log function
    public double naturalLog(double num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Cannot compute the natural logarithm of a negative number");
        }
        return Math.log(num);
    }

    // handle natural log function
    private void handleNaturalLog() {
        System.out.print("Enter the number to calculate the natural logarithm of: ");

        try {
            double num = scanner.nextDouble();
            double log = naturalLog(num);
            System.out.println("Natural Logarithm of " + num + " is " + log);
        } catch (InputMismatchException e) {
            System.out.println("Enter a number to calculate the natural logarithm!");
            scanner.nextLine(); // move to the next line
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // power function
    public double power(double a, double b) { // returns a^b
        return Math.pow(a, b);
    }

    // handle power function
    private void handlePower() {
        try {
            System.out.print("Enter the base number: ");
            double a = scanner.nextDouble();
            System.out.print("Enter the exponent: ");
            double b = scanner.nextDouble();
            double pow = power(a, b);
            System.out.println(a + " raised to the power " + b + " is " + pow);
        } catch (InputMismatchException e) {
            System.out.println("Enter a valid number to compute power.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // display menu function
    private void displayMenu() {
        System.out.println("----------Menu------------");
        System.out.println("1. Square root operation (√x)");
        System.out.println("2. Factorial operation (x!)");
        System.out.println("3. Natural logarithm (base e) operation (ln(x))");
        System.out.println("4. Power function operation (x^b)");
        System.out.println("5. Exit the calculator");
        System.out.println("----------------------------");
    }

    // run function
    public void run() {
//        scanner.nextLine();
        boolean want_to_exit = false;

        System.out.println("\nWelcome to the Scientific Calculator!\n");
        do { // loop until user wants to exit (do-while loop)
            displayMenu();
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        handleSquareRoot();
                        break;
                    case 2:
                        handleFactorial();
                        break;
                    case 3:
                        handleNaturalLog();
                        break;
                    case 4:
                        handlePower();
                        break;
                    case 5:
                        want_to_exit = true;
                        System.out.println("Thank you for using the calculator.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }
            } catch(InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        } while (!want_to_exit);

        scanner.close();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}