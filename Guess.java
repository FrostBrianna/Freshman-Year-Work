//Brianna Frost
//COMP 163
//9 October 2019
//Assignment 5

//This program will allow the user to play a game and guess a 
//number between 1 and the specified range

import java.util.*;

public class Guess {
   //allows for the range to be set to a specific number
   public static final int RANGE = 100;
   
   //uses scanner and random number to prompt user for a guess
   //allows them to play the game multiple times using a while loop and
   //then prints the overall statistics of their games
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      Random randy = new Random();
      
      intro();
      
      int totalGames = 0;
      int totalGuesses = 0;
      double guessesPerGame = 0;
      int bestGame = 9999;
      String playAgain = "yes";
      
      while(playAgain.charAt(0) == 'y' || playAgain.charAt(0) == 'Y') {
         int numGuesses = game(console, randy);
         totalGames++; 
         
         totalGuesses = totalGuesses + numGuesses;
         
         if(numGuesses < bestGame) {
            bestGame = numGuesses;
         }
       
         System.out.print("Do you want to play again? ");
         System.out.println();
         playAgain = console.next();
         System.out.println();
      }
      
      reportResult(totalGuesses,totalGames,guessesPerGame,bestGame);
  
   }
   
   //prints the directions of the game using various println statements
   public static void intro() {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println(RANGE + " and will allow you to guess until");
      System.out.println("you get it. For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
      System.out.println();
   }
   
   //runs one complete iteration of the game prompting the user for a guess
   //gives the user a higher or lower statement using an if statement
   // prints the number of guesses and returns the value to main
   public static int game(Scanner console, Random randy) {
      System.out.println("I'm thinking of a number between 1 and " + RANGE + "...");
      
      int secret = randy.nextInt(RANGE) + 1;      
      int guess = -1;
      int numGuesses = 0;
      
      while (secret != guess){      
         System.out.print("Your guess? ");
         guess = console.nextInt();
         numGuesses++;
                           
         if(guess > secret){
            System.out.println("It's lower.");
         } else if(guess < secret) {
            System.out.println("It's higher.");
         }     
      } 
      
      if(numGuesses == 1) {
         System.out.println("You got it right in " + numGuesses + " guess.");
      } else {
         System.out.println("You got it right in " + numGuesses + " guesses.");
      }
      
      return numGuesses;
   }
   
   //print the statistics of all of the games using parameters and println statements
   public static void reportResult(int totalGuesses, int totalGames, 
                                    double guessesPerGame, int bestGame) {
      guessesPerGame = totalGuesses / totalGames;

      System.out.println("Overall results:");
      System.out.println("  total games   = " + totalGames);
      System.out.println("  total guesses = " + totalGuesses);
      System.out.println("  guesses/game  = " + guessesPerGame);
      System.out.println("  best game     = " + bestGame);

   }
}