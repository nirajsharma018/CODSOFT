package Task1;
import java.util.Random;
import java.util.Scanner;

public class GuesingGame {

    private int generateRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    private int promptUserForGuess(Scanner scanner) {
        System.out.print("Enter your guess: ");
        return scanner.nextInt();
    }

    private boolean playRound(Scanner scanner, int roundLimit, int min, int max) {
        int randomNumber = generateRandomNumber(min, max);
        int attempts = 0;
        boolean guessedCorrectly = false;

        while (attempts < roundLimit) {
            int userGuess = promptUserForGuess(scanner);
            attempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                guessedCorrectly = true;
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry! You've used all your attempts. The correct number was " + randomNumber);
        }

        return guessedCorrectly;
    }

    private void startGame() {
        Scanner scanner = new Scanner(System.in);
        int min = 1;
        int max = 100;
        int roundLimit = 10;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("New Round! Try to guess the number between " + min + " and " + max);
            boolean won = playRound(scanner, roundLimit, min, max);

            if (won) {
                score++;
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String userResponse = scanner.next();
            playAgain = userResponse.equalsIgnoreCase("yes");
        }

        System.out.println("Game Over! Your score is: " + score);
        scanner.close();
    }

    public static void main(String[] args) {
        Task1.GuesingGame game = new Task1.GuesingGame();
        game.startGame();
    }
}
