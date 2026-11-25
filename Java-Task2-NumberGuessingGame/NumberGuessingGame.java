
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String playAgain;
        int round = 0;
        int score = 0;

        do {

            round++;

            int maxNumber = 100;
            int maxAttempts = 7;

            System.out.println("\n===== NUMBER GUESSING GAME =====");
            System.out.println("Choose Difficulty:");
            System.out.println("1. Easy (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard (1-200, 5 attempts)");

            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Please enter a number (1, 2 or 3).");
                sc.next();
                System.out.print("Enter your choice: ");
            }

            int choice = sc.nextInt();

            while (choice < 1 || choice > 3) {
                System.out.println("Invalid choice! Select 1, 2 or 3.");
                System.out.print("Enter your choice: ");

                while (!sc.hasNextInt()) {
                    System.out.println("Please enter a number.");
                    sc.next();
                    System.out.print("Enter your choice: ");
                }

                choice = sc.nextInt();
            }

            if (choice == 1) {
                maxNumber = 50;
                maxAttempts = 10;
                System.out.println("Easy Mode Selected!");
            }
            else if (choice == 2) {
                maxNumber = 100;
                maxAttempts = 7;
                System.out.println("Medium Mode Selected!");
            }
            else {
                maxNumber = 200;
                maxAttempts = 5;
                System.out.println("Hard Mode Selected!");
            }

            int secretNumber = random.nextInt(maxNumber) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Round: " + round);
            System.out.println("Guess a number between 1 and " + maxNumber);
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts && !guessedCorrectly) {

                System.out.print("Enter your guess: ");

                while (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Enter a whole number.");
                    sc.next();
                    System.out.print("Enter your guess: ");
                }

                int guess = sc.nextInt();

                if (guess < 1 || guess > maxNumber) {
                    System.out.println("Enter a number between 1 and " + maxNumber);
                    continue;
                }

                attempts++;

                System.out.println("Attempt: " + attempts + " / " + maxAttempts);

                if (guess > secretNumber) {
                    System.out.println("Too High!");
                }
                else if (guess < secretNumber) {
                    System.out.println("Too Low!");
                }
                else {
                    System.out.println("Correct!");
                    System.out.println("Congratulations!");
                    guessedCorrectly = true;
                    score++;
                }
            }

            if (guessedCorrectly) {
                System.out.println("Round " + round +
                        " guessed in " + attempts + " attempts.");
            }
            else {
                System.out.println("You Lost!");
                System.out.println("The correct number was: " + secretNumber);
                System.out.println("Round " + round + " not guessed.");
            }

            System.out.println("Your total score: " + score);

            System.out.print("\nPlay Again? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes")
                || playAgain.equalsIgnoreCase("y"));

        System.out.println("\n===== FINAL RESULTS =====");
        System.out.println("Total rounds played: " + round);
        System.out.println("Total rounds won: " + score);
        System.out.println("Final score: " + score);
        System.out.println("\nThank you for playing!");

        sc.close();
    }
}
