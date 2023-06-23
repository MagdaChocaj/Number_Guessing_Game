package org.example;

import java.util.*;

public class Main {
    public static int turn = 1;
    public static boolean shouldContinue = true;
    public static Scanner scanner = new Scanner(System.in);
    public static List<Integer> previousGuesses = new ArrayList<>(10);
    public static Random randomNumber = new Random();

    public static void main(String[] args) {

        int generatedNumber = randomNumber.nextInt(100);

        System.out.println("Number guessing game");
        System.out.println("We have selected a random number between 1 and 100. See if you can guess it in 10 turns or fewer. We'll tell you if your guess was too high or too low.");

        while(shouldContinue) {

            System.out.println("Enter a guess:");
            int userNumber = scanner.nextInt();
            previousGuesses.add(userNumber);
            System.out.println("Previous guesses:" + previousGuesses);

            if (userNumber == generatedNumber) {
                System.out.println("Congratulations! You guessed the number!");
                shouldContinue = false;

            } else if (turn == 10) {
                System.out.println("You have no turns left");
                shouldRestart();
                previousGuesses.clear();
                turn = 0;
                generatedNumber = randomNumber.nextInt(100);

            } else if (userNumber < generatedNumber) {
                System.out.println("The number is too low");

            } else if (userNumber > generatedNumber) {
                System.out.println("The number is too high");

            }
            turn++;
        }
    }
    private static void shouldRestart() {
        boolean shouldRestart = true;
        while (shouldRestart) {
            System.out.println("Do you want to restart the game? Y/N");
            String answer = scanner.nextLine();

            if (answer.equals("Y")) {
                shouldContinue = true;
                shouldRestart = false;

            } else if (answer.equals("N")) {
                shouldContinue = false;
                shouldRestart = false;

            }
        }
    }
}