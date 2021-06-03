package ru.n5y.hackerrank.introduction;

import java.util.Locale;
import java.util.Scanner;

public class StringIntroduction {
  public static void main(String[] args) {

    try (Scanner sc = new Scanner(System.in)) {
      final String A = sc.next();
      final String B = sc.next();
      /* Enter your code here. Print output to STDOUT. */
      System.out.println(A.length() + B.length());
      System.out.println(A.compareToIgnoreCase(B) <= 0 ? "No" : "Yes");
      System.out.println(capitalize(A) + " " + capitalize(B));
    }

  }

  private static String capitalize(String s) {
    if (s.length() == 0) {
      return s;
    }
    if (s.length() == 1) {
      return s.toUpperCase(Locale.ROOT);
    }
    return s.substring(0, 1).toUpperCase(Locale.ROOT) + s.substring(1);

  }
}
