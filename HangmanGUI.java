//Brianna Frost
//COMP 163
//2 December 2019
//
//HangmanGUI creates the gui consiting of labels, textfields, and buttons. Uses guesses
//from the user to create new dashed words.
//Extra functions: records the total number of guesses, and takes the max guesses
//allowed from the user.
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

// Starter code for HangmanGUI.
public class HangmanGUI extends JFrame implements ActionListener {

   //creates private fields for labels, variables, textfields and buttons
   //used within the gui program
   // TODO: YOUR CODE HERE
   // Add any necessary fields to keep track of state
   private JLabel dash;
   private JLabel usedLetters;
   private JLabel guessLetter;
   private JTextField guessInput;
   private JButton guessButton;
   private JButton hintButton;
   private JLabel guessRemain;
   private int guessesLeft;
   private String guessedLetters;
   private String word;
   private JLabel incorrectGuess;
   private JLabel gameOver;
   private JLabel totalGuesses;
   private int total;
   
   //takes a parameter of secretWord and maxGuesses from HangmanClient
   //sets the size of GUI and places each object into the gui
   //sets guessesLeft and word to the given parameters from the user
   //initializes the guessedLetters string to a blank string
   public HangmanGUI(String secretWord, int maxGuesses) {
      setSize(700, 125);
      setTitle("Hangman Game");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
         
      // TODO: YOUR CODE HERE
      // Add any GUI components and initialize any necessary state
      guessesLeft = maxGuesses;
      guessedLetters = "";
      word = secretWord;
      total = 0;
           
      Container pane = getContentPane();
      
      gameOver = new JLabel();
      pane.add(gameOver);
      
      dash = new JLabel(convertToPattern(word, guessedLetters));
      pane.add(dash);
      
      usedLetters = new JLabel("Used Letters: " );
      pane.add(usedLetters);
      
      JLabel guessLetter = new JLabel("Guess a letter: ");
      pane.add(guessLetter);
      
      guessInput = new JTextField();
      pane.add(guessInput);
      
      guessButton = new JButton("Guess");
      pane.add(guessButton);
      guessButton.addActionListener(this);
      
      incorrectGuess = new JLabel();
      pane.add(incorrectGuess);
      
      guessRemain = new JLabel("Guesses left: " + guessesLeft);
      pane.add(guessRemain);
      
      hintButton = new JButton("Hint");
      pane.add(hintButton);
      hintButton.addActionListener(this);
        
      totalGuesses = new JLabel();
      pane.add(totalGuesses);
      
           
      // layout
      GridLayout layout = new GridLayout(4, 3);
      setLayout(layout);
   }
   
   //action takes place each time a button is clicked
   //determines whether the hint or guess button was clicked using if statements
   //decreses the number of guess and sets the text to display new numbers
   //updates the dashed word shown to the user and keeps track of the letters 
   //the user has guessed. Uses and if statement to tell the player whether they
   //have won or lost the game.
   public void actionPerformed(ActionEvent event) {
      // TODO: YOUR CODE HERE
      // Handle any events  
      String userInput = guessInput.getText();
      String dashedWord = dash.getText();
            
      if (event.getSource() == hintButton) {
         guessesLeft = guessesLeft - 2;
         if(guessesLeft < 0){
            guessesLeft = 0;
         }
         guessRemain.setText("Guesses left: " + guessesLeft);
         char hint = getHintLetter(word, guessedLetters);
         guessedLetters = guessedLetters + " " + hint;
         dashedWord = convertToPattern(word, guessedLetters); 
         dash.setText(dashedWord);        
      } 
      
      if(event.getSource() == guessButton){
         guessedLetters = guessedLetters + " " + userInput;
         if(word.contains(userInput)){
            dashedWord = convertToPattern(word, guessedLetters);
            dash.setText(dashedWord);
            incorrectGuess.setText("Correct Guess: " + userInput);        
         } else {
            guessesLeft--;
            if(guessesLeft < 0){
               guessesLeft = 0;
            }
            guessRemain.setText("Guesses left: " + guessesLeft);
            incorrectGuess.setText("Incorrect Guess: " + userInput);
         }  
         total++;   
      }
      usedLetters.setText("Used Letters: " + guessedLetters);
      totalGuesses.setText("Total Guesses: " + total);
      
      if(guessesLeft > 0 && !dashedWord.contains("-")){
         gameOver.setText("You Win!");
      } else if(guessesLeft == 0){
         gameOver.setText("You Lose!");
      }       
   }
   
   // Helper method that takes a String word and a String of the letters
   // guessed so far, and returns a pattern representing that word where each 
   // letter in the word that has not been guessed so far is represented as a dash.
   // 
   // Example: given the word "apple" and guessedLetters "o i e s p", returns "- p p - e".
   private static String convertToPattern(String word, String guessedLetters) {
      String result = "";
      for (int i = 0; i < word.length(); i++) {
         if (guessedLetters.contains("" + word.charAt(i))) {
            result += word.charAt(i) + " ";
         } else {
            result += "- ";
         }
      }
      return result.trim();
   }
   
   // Helper method that takes a String word and a String of the letters
   // guessed so far, and returns a Random character left in the word
   // that has not been guessed so far. If all characters have been guessed, returns
   // the empty character.
   //
   // Example: given the word "apple" and guessedLetters "o i e s p", could return 'a' or 'l'
   private static char getHintLetter(String word, String guessedLetters) {
      String lettersLeft = "";
      for (int i = 0; i < word.length(); i++) {
         if (!guessedLetters.contains("" + word.charAt(i))) {
            lettersLeft += word.charAt(i);
         }
      }
      if (lettersLeft.length() == 0) {
         return '\0';
      }
      Random r = new Random();
      int randomIndex = r.nextInt(lettersLeft.length());
      return lettersLeft.charAt(randomIndex);
   }
}
 