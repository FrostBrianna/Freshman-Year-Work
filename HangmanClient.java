//Brianna Frost
//COMP 163
//2 December 2019
//
//Hangman Client code creates a hangman game for the user to play given a 
//max number of guesses and a word given by the user.
import java.util.*;

// Starter code for Hangman client code.
//Creates a scanner object and ask the user for the secret word and the max
//number of guesses. Creates a hangmanGUI and sets it to visible.
public class HangmanClient {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      System.out.print("secret word? ");
      String secretWord = console.next();
      System.out.print("max guesses? ");
      int maxGuesses = console.nextInt();
      // TODO: YOUR CODE HERE
      // create a HangmanGUI and set it to be visible.
      HangmanGUI gui = new HangmanGUI(secretWord, maxGuesses);
      gui.setVisible(true);
   }
}   