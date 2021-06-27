package ru.n5y.hackerrank.bignumber;

import java.math.BigInteger;
import java.util.Scanner;

public class JavaBigInteger {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      final BigInteger a = new BigInteger(scanner.nextLine());
      final BigInteger b = new BigInteger(scanner.nextLine());
      System.out.println(a.add(b));
      System.out.println(a.multiply(b));
    }
  }
}
