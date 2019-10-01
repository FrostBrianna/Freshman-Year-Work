//Brianna Frost
//COMP 163
//September 26 2019
//Assignment 4

//This program compares the gpa and sat scores of two applicants provides the values and states the better applicant

import java.util.*;

public class Admissions {
   public static void main(String[] args){
      //compares two applicants using multiple score inputs, states which is better
      intro();
      Scanner console = new Scanner(System.in);
      
      double score1 = getScore(console, 1);
      double score2 = getScore(console, 2);
      compareApplicants(score1, score2);
   }
   
   public static void intro() {
      //gives description of what the program performs
      System.out.println("This program compares two applicants to");
      System.out.println("determine which one seems like the stronger");
      System.out.println("applicant. For each candidate I will need");
      System.out.println("either SAT or ACT scores plus a weighted GPA.");
      System.out.println();
   }
   
   public static double getScore(Scanner console, int applicant) {
      //finds value of score of each applicant and returns the value to main
      System.out.println("Information for applicant #" + applicant  + ":");
      double score = scoreFor(console); 
      return score;
   }
   
   public static double scoreFor(Scanner console) {
      //finds score using getExamScore and getGPA and returns value to getScore
      return getExamScore(console) + getGPA(console);
   }
   
   public static double getExamScore(Scanner console) {
      //ask user which test they took and performs and if else statement to find score
      System.out.print("do you have 1) SAT scores or 2) ACT scores?"); 
      int test = console.nextInt();
      if (test == 1) {
         return getSat(console);  
      } else {        
         return getAct(console);  
      }    
   }
   
   public static double getSat(Scanner console) {
      //uses inputs from the user to determine sat score
      System.out.print("SAT math?"); 
      int satMath = console.nextInt();
      System.out.print("SAT critical reading?"); 
      int satReading = console.nextInt();
      System.out.print("SAT writing?"); 
      int satWriting = console.nextInt();
      double satScore = findSat(satMath, satReading, satWriting); 
      System.out.print("Exam score = " + round1(satScore));
      System.out.println();
      return satScore;
   }
   
   public static double getAct(Scanner console) {
      //uses inputs from the user to determine act score
      System.out.print("ACT English?");
      int actEnglish = console.nextInt();
      System.out.print("ACT math?");
      int actMath = console.nextInt();
      System.out.print("ACT reading?");
      int actReading = console.nextInt();
      System.out.print("ACT science?");
      int actScience = console.nextInt();
      double actScore = findAct(actEnglish, actMath, actReading, actScience);
      System.out.print("Exam score = " + round1(actScore)); 
      System.out.println();
      return actScore;
   }
   
   public static double findSat(int satMath, int satReading, int satWriting) {
      //returns value to findSat after performing equation using users inputs
      return (((2 * satMath) + satReading + satWriting) / 32);
   }
   
   public static double findAct(int actEnglish, int actMath, int actReading, int actScience) {
      //returns value to findAct after performing equation using users inputs
      return (actEnglish + (2 * actMath) + actReading + actScience) / 1.8;
   }
   
   public static double getGPA(Scanner console) {
      //finds the applicants GPA score using inputs
      System.out.print("overall GPA?"); 
      double overallGpa = console.nextDouble();
      System.out.print("max GPA?"); 
      double maxGpa = console.nextDouble();
      System.out.print("Transcript Multiplier?"); 
      double transcriptMultiplier = console.nextDouble();
      double GPA = gpaFor(overallGpa, maxGpa, transcriptMultiplier);
      System.out.println("GPA Score = " + round1(GPA));
      System.out.println();
      return GPA;
   }  
      
   public static double gpaFor(double overallGpa, double maxGpa, double transcriptMultiplier) {
      //returns a value to getGPA after performing an equation
      return (overallGpa / maxGpa) * 100 * transcriptMultiplier; 
   }
   
   public static void compareApplicants(double score1, double score2) {
      //states applicants overall scores and compares applicants
      System.out.println("First applicant overall score = " + round1(score1));
      System.out.println("Second applicant overall score = " + round1(score2));
      betterApplicant(score1, score2);
   }
 
   public static double round1(double n) {
      //method rounds numbers to tens place
      return Math.round(n * 10.0) / 10.0;
   }

   public static void betterApplicant(double score1, double score2) {
      //uses an if else statement to compare applicants
      if (score1 > score2) {
         System.out.println("The first applicant seems to be better");
      } else if (score1 < score2) {
         System.out.println("The second applicant seems to be better");
      } else {
         System.out.println("The two applicants seem to be equal.");
      }
   }

}