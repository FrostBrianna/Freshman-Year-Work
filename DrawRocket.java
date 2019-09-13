/*
Brianna Frost
September 10 2019
COMP 163
Assignment 2

This code will display an image of a rocketship depending on the size
*/

public class DrawRocket {

   // SIZE allows image to change based on input
   public static final int SIZE = 5;
   
   // draw image of a rocketship
   public static void main(String[] args) {
     drawTriangle();
     drawLine();
     drawTopBox();
     drawBottomBox();
     drawLine();
     drawBottomBox();
     drawTopBox();
     drawLine();
     drawTriangle();
    }
    
    public static void drawTriangle() {
     //draw the tip and bottom of the rocket
       for(int line = 1; line <= 2 * SIZE - 1; line++) {
         for (int spaces = 1; spaces <= -1 * line + (SIZE * 2); spaces++) {
            System.out.print(" ");
         }
         for (int slash = 1; slash <= line; slash++) {
            System.out.print("/");
         }
         System.out.print("**");
         for (int bslash = 1; bslash <= line; bslash++) {
            System.out.print("\\");
         }
         System.out.println();
       }
    }
    
    public static void drawLine() {
    //draw line made of = and *
      System.out.print("+");
      for (int i = 1; i <= SIZE * 2 ; i++) {
         System.out.print("=");
         System.out.print("*");
      }
      System.out.println("+");
    }
    
    public static void drawTopBox() {
    //draw top half of the body
      for (int line = 1; line <= SIZE; line++) {
         System.out.print("|");
         for (int dots = 1; dots <= -1 * line + SIZE; dots++) {
            System.out.print(".");
         }
         for (int i = 1; i <= line; i++) {
            System.out.print("/");
            System.out.print("\\");
         }
         for (int dots = 1; dots <= -2 * line + (2 * SIZE); dots++) {
            System.out.print(".");
         }
         for (int j = 1; j <= line; j++) {
            System.out.print("/");
            System.out.print("\\");
         }
         for (int dots = 1; dots <= -1 * line + SIZE; dots++) {
            System.out.print(".");
         }
         System.out.print("|");
         System.out.println();
      }
    }
    
    public static void drawBottomBox() {
    //draw bottom half of the body
      for (int line = 1; line <= SIZE; line++) {
         System.out.print("|");
         for (int dots = 1; dots <= line - 1; dots++) {
            System.out.print(".");
         }
         for (int i = 1; i <= -1 * line + (1 + SIZE); i++) {
            System.out.print("\\");
            System.out.print("/");
         }
         for (int dots = 1; dots <= 2 * line - 2; dots++) {
            System.out.print(".");
         }
         for (int j = 1; j <= -1 * line + (1 + SIZE); j++) {
            System.out.print("\\");
            System.out.print("/");
         }
         for (int dots = 1; dots <= line - 1; dots++) {
            System.out.print(".");
         }
         System.out.print("|");
         System.out.println();
      }

    }

}