//Brianna Frost
//COMP 163
//Ascii Art Assignment 3
//September 2019

//This program will draw an image of a diamond

public class AsciiArt {
   public static void main(String[] args) {
      drawTop();
      drawBottom();
   }
   public static void drawTop() {
      //draw top half of the diamond
      for(int line = 1; line <= 5; line++) {
         for(int space = 1; space <= -1 * line + 6; space++) {
            System.out.print(" ");
         }
         for(int slash = 1; slash <= 1 * line + 15; slash++) {
            System.out.print("/");
         }
         for(int bslash = 1; bslash <= 1 * line + 15; bslash++) {
            System.out.print("\\");
         }
         System.out.println();
      }
   }
   public static void drawBottom() {
      //draw bottom half of the diamond
      for(int line = 1; line <= 20; line++) {
         for(int space = 1; space <= line; space++) {
            System.out.print(" ");
         }
         for(int bslash = 1; bslash <= -1 * line + 21; bslash++) {
            System.out.print("\\");
         }
         for(int slash = 1; slash <= -1 * line + 21; slash++) {
            System.out.print("/");
         }
         System.out.println();
      }

   }
}   
