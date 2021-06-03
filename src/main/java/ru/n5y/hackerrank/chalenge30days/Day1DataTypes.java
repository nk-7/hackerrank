package ru.n5y.hackerrank.chalenge30days;

import java.util.Scanner;

public class Day1DataTypes {
  public static void main(String[] args) {
    int i = 4;
    double d = 4.0;
    String s = "HackerRank ";

    try (final Scanner scan = new Scanner(System.in)) {

      /* Declare second integer, double, and String variables. */

      /* Read and save an integer, double, and String to your variables.*/
      // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.

      final int i2 = scan.nextInt();
      final double d2 = scan.nextDouble();
      scan.nextLine();
      final String s2 = scan.nextLine();

      /* Print the sum of both integer variables on a new line. */
      System.out.println(i + i2);
      /* Print the sum of the double variables on a new line. */
      System.out.printf("%.1f\n", d + d2);

        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */
      System.out.println(s + s2);
    }
  }
}
