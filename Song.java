/* Brianna Frost
August 28 2019
Comp 163
Assignment 1
*/

// this program will write out the lyrics to a repetitive song
public class Song {
   public static void main(String[] args){
      // display lyrics of the song
      verseOne();
      verseTwo();
      verseThree();
      verseFour();
      verseFive();
      verseSix();
      verseSeven();   
    }
    
    public static void die() {
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
      System.out.println();
    }
    
    public static void repeatOne() {
      System.out.println("She swallowed the bird to catch the spider,");
      System.out.println("She swallowed the spider to catch the fly,");
      die();
    }
    
    public static void repeatTwo() {
      System.out.println("She swallowed the cat to catch the bird,");
      repeatOne();
    }
    
    public static void repeatThree() {
      System.out.println("She swallowed the dog to catch the cat,");
      repeatTwo();
    }
    
    public static void verseOne() {
      System.out.println("There was an old woman who swallowed a fly.");
      die();
    }
    
    public static void verseTwo() {
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      System.out.println("She swallowed the spider to catch the fly,");
      die();
    }
    
    public static void verseThree() {
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      repeatOne();
    }
    
    public static void verseFour() {
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      repeatTwo();
    }
    
    public static void verseFive() {
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      repeatThree();
    }
    
    public static void verseSix() {
      System.out.println("There was an old woman who swallowed a pig,");
      System.out.println("Must be big to swallow a pig.");
      System.out.println("She swallowed the pig to catch the dog,");
      repeatThree();
     }
     
     public static void verseSeven() {
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course."); 
     }
}