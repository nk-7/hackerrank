package ru.n5y.hackerrank.introduction;

import java.util.Locale;
import java.util.Scanner;

public class StdinAndStdout2 {

  public static void main(String[] args) {
    try (final Scanner scan = new Scanner(System.in).useLocale(Locale.US)) {
      final int i = scan.nextInt();
      final double d = scan.nextDouble();
      scan.nextLine(); // Skip empty string reminder from last read.
      final String s = scan.nextLine();

      System.out.println("String: " + s);
      System.out.println("Double: " + d);
      System.out.println("Int: " + i);
    }
  }

}
