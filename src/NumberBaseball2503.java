import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NumberBaseball2503 {
    
    private static final int NUM_DIGITS = 3;
    private static final Random rand = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int[] answer = generateAnswer();
        System.out.println("Welcome to Number Baseball!");
        while (true) {
            System.out.print("Enter your guess (3 digits with no repeats): ");
            int[] guess = readGuess();
            if (guess == null) {
                continue;
            }
            int[] result = getResult(guess, answer);
            if (result[0] == NUM_DIGITS) {
                System.out.println("You win!");
                break;
            } else {
                System.out.printf("%d strike(s), %d ball(s)\n", result[0], result[1]);
            }
        }
        scanner.close();
    }
    
    private static int[] generateAnswer() {
        int[] digits = new int[10];
        for (int i = 0; i < 10; i++) {
            digits[i] = i;
        }
        int[] answer = new int[NUM_DIGITS];
        for (int i = 0; i < NUM_DIGITS; i++) {
            int j = rand.nextInt(10 - i);
            answer[i] = digits[j];
            digits[j] = digits[9 - i];
        }
        return answer;
    }
    
    private static int[] readGuess() {
        String guessStr = scanner.nextLine();
        if (guessStr.length() != NUM_DIGITS) {
            System.out.println("Invalid guess. Please enter 3 digits with no repeats.");
            return null;
        }
        int[] guess = new int[NUM_DIGITS];
        for (int i = 0; i < NUM_DIGITS; i++) {
            char c = guessStr.charAt(i);
            if (c < '0' || c > '9') {
                System.out.println("Invalid guess. Please enter 3 digits with no repeats.");
                return null;
            }
            int digit = c - '0';
            if (Arrays.asList(guess).contains(digit)) {
                System.out.println("Invalid guess. Please enter 3 digits with no repeats.");
                return null;
            }
            guess[i] = digit;
        }
        return guess;
    }
    
    private static int[] getResult(int[] guess, int[] answer) {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < NUM_DIGITS; i++) {
            if (guess[i] == answer[i]) {
                strikes++;
            } else if (Arrays.asList(answer).contains(guess[i])) {
                balls++;
            }
        }
        return new int[] { strikes, balls };
    }
}
