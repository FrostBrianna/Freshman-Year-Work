//Brianna Frost
//COMP 163
//21 October 2019
//Assignment 6

//This program allows a user to create or view a madlib and then quit the program,
import java.util.*; 
import java.io.*; 

public class MadLibs {
   public static void main(String[] args) throws FileNotFoundException{
      Scanner console = new Scanner(System.in);
      boolean madLibGame = true;
      
      intro();
      
      while(madLibGame == true) {
         madLibGame = userInteraction(console);
      }
   }
   
   //gives an intro to the program to the user using println statements
   public static void intro() {
      System.out.println("Welcome to the game of MadLibs.");
		System.out.println("I will ask you to provide various words ");
		System.out.println("and phrases to fill a story.");
		System.out.println("The result will be written to an output file.");
   }
   
   //provides a menu and prompts the user for a response. 
   //Uses multiple if statements and returns a boolean value to main
   public static boolean userInteraction(Scanner console)throws FileNotFoundException {
      System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit?");
      String menuOption = console.next();
      if(menuOption.charAt(0) == 'C' || menuOption.charAt(0) == 'c') {
         createMadLib(console);
         return true;
      }  
      if (menuOption.charAt(0) == 'V' || menuOption.charAt(0) == 'v') {
         viewMadLib(console);
         return true;
      }  
      if(menuOption.charAt(0) == 'Q' || menuOption.charAt(0) == 'q') {
         return false;
      } else {
         return true;
      }
   }
   
   //Takes in a file name from the user to view/display
   //Uses scanner input and a while loop to display each line of the file
   public static void viewMadLib(Scanner console)throws FileNotFoundException {
      System.out.print("View file name: ");
      String fileName = console.next();
      System.out.println();
      
      Scanner input = new Scanner(new File(fileName));
		
      while(input.hasNextLine()){
			String text = input.nextLine();
         System.out.println(text);
		}
      System.out.println();
   }
   
   //Allows the user to create a madlib of their own after inputing two file names
   //Calls processLine method and prints the results 
   public static void createMadLib(Scanner console)throws FileNotFoundException {
      System.out.print("Input file name: ");
      String fileInput = console.next();
      File f1 = new File(fileInput);
      
      System.out.print("Output file name: ");
      String fileOutput = console.next();
      File out = new File(fileOutput);
		PrintStream output = new PrintStream(out);
      
      System.out.println();
      
      Scanner input = new Scanner(f1);
      
      while (input.hasNextLine()) {
         String line = input.nextLine();
         processLine(line, console, output);
         output.println();
       }
       System.out.println("Your mad-lib has been created!");
       System.out.println();

   }
   
   //Takes in a number of parameters from create method 
   //Goes through each token to find placeholders and prompts the user for an answer
   //replaces the placeholder with users answer and prints new file
   public static void processLine(String line, Scanner console, PrintStream output) {
      Scanner tokens = new Scanner(line);

      while (tokens.hasNext()) {
         String token = tokens.next();
         if (token.startsWith("<") && token.endsWith(">")) {
            String placeholder = token.substring(token.indexOf("<") + 1, token.indexOf(">"));
            char first = placeholder.charAt(0);
            String anOrA;
            
            if(first == 'a' || first == 'A' || first == 'i' || first == 'I' 
			      || first == 'i' || first == 'e' || first == 'E' ||
			      first == 'o' || first == 'O' || first == 'u' || first == 'U'){
			
               anOrA = "an";
		      } else{
			      anOrA = "a";
		      }
            
            if(placeholder.contains("-")) {
               placeholder = placeholder.replace("-"," ");
            }
            
            System.out.print("Please type " + anOrA + " " + placeholder +": ");
            token = console.next();
            output.print(token + " ");

         } else {
            output.print(token + " ");
         }
      }
   }
}