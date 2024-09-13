package org.example;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;

        while (true) {
            int numberToGuess = getRandomNumber(random, LOWER_BOUND, UPPER_BOUND);
            boolean guessedCorrectly = playRound(scanner, numberToGuess);

            if (guessedCorrectly) {
                score++;
            }

            System.out.println("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Game over. Your final score is " + score + ".");
        scanner.close();
    }

    private static int getRandomNumber(Random random, int lower, int upper) {
        return random.nextInt(upper - lower + 1) + lower;
    }

    private static boolean playRound(Scanner scanner, int numberToGuess) {
        int attempts = 0;

        System.out.println("Guess the number between " + LOWER_BOUND + " and " + UPPER_BOUND + ". You have " + MAX_ATTEMPTS + " attempts.");

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high.");
            } else {
                System.out.println("Congratulations! You guessed the number " + numberToGuess + " correctly in " + attempts + " attempts.");
                return true;
            }
        }

        System.out.println("Sorry, you've used all " + MAX_ATTEMPTS + " attempts. The number was " + numberToGuess + ".");
        return false;
    }
}
