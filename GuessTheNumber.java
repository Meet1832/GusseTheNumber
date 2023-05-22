import java.util.Random;
import javax.swing.JOptionPane;
public class GuessTheNumber {
    public static void main(String[] args) {
        int minRange = 1; 
        int maxRange = 100; 
        int maxAttempts = 5; 
        int score = 0; 
        Random random = new Random();
        
        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            boolean guessedCorrectly = false;
            int attempts = 0;
            while (!guessedCorrectly && attempts < maxAttempts) {
                String guessString = JOptionPane.showInputDialog(null, "Guess the number between "
                        + minRange + " and " + maxRange);
                int guess = Integer.parseInt(guessString);
                if (guess == randomNumber) {
                    guessedCorrectly = true;
                    score += (maxAttempts - attempts) * 10;
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number "
                            + randomNumber + " correctly.\nScore: " + score);
                } else if (guess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                }
                
                attempts++;
            }
            
            if (!guessedCorrectly) {
                JOptionPane.showMessageDialog(null, "Game over! You couldn't guess the number. "
                        + "The number was " + randomNumber + ".");
            }
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
            if (choice != JOptionPane.YES_OPTION) {
                playAgain = false;
            }
        }
        JOptionPane.showMessageDialog(null, "Thanks for playing! Final Score: " + score);
        System.out.print("m");
    }
}