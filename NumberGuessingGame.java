import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int secretNumber = (int) (Math.random() * 100) + 1; //Maths.random() ->It returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0
        int guessesCount = 0;
        int guess;

        System.out.println("I'm thinking of a number between 1 and 100. Can you guess what it is?");

        do {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            guessesCount++;

            if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > secretNumber) {
                System.out.println("Too high! Try again.");
            }
        } while (guess != secretNumber);

        System.out.println("Congratulations! You guessed the number in " + guessesCount + " guesses.");
    }
}
