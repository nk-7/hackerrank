package ru.n5y.hackerrank.introduction;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Datatypes {

  public static void main(String[] argh) {
    try (Scanner sc = new Scanner(System.in)) {
      int t = sc.nextInt();
      for (int i = 0; i < t; i++) {
        try {
          long x = sc.nextLong();
          System.out.println(x + " can be fitted in:");
          if (x >= -128 && x <= 127) {
            System.out.println("* byte");
            System.out.println("* short");
            System.out.println("* int");
            System.out.println("* long");
          } else if (x >= -32_768 && x <= 32_767) {
            System.out.println("* short");
            System.out.println("* int");
            System.out.println("* long");
          } else if (x >= -2_147_483_648 && x <= 2_147_483_647) {
            System.out.println("* int");
            System.out.println("* long");
          } else if (x >= -9_223_372_036_854_775_808L && x <= 9_223_372_036_854_775_807L) {
            System.out.println("* long");
          }
          //Complete the code
        } catch (InputMismatchException e) {
          System.out.println(sc.next() + " can't be fitted anywhere.");
        }
      }
    }
  }
}
