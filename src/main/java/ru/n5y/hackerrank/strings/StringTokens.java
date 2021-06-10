package ru.n5y.hackerrank.strings;

import java.util.Scanner;

public class StringTokens {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = scan.nextLine();
    // Write your code here.
    if (s == null || s.trim().length() == 0) {
      System.out.println(0);
    } else {
      final String[] split = s.trim().split("[^a-zA-Z]+");
      System.out.println(split.length);
      for (String value : split) {
        System.out.println(value);
      }
    }
    scan.close();
  }
}
