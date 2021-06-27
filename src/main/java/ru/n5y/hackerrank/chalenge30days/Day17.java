package ru.n5y.hackerrank.chalenge30days;

import java.util.Scanner;

public class Day17 {

  static class Calculator {
    public int power(int n, int p) {
      if (n < 0 || p < 0) {
        throw new IllegalArgumentException("n and p should be non-negative");
      }
      if (n == 0) {
        return 0;
      }
      if (p == 0) {
        return 1;
      }
      int res = n;
      for (int i = 1; i < p; i++) {
        res = res * n;
      }
      return res;
    }
  }

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {

      int n = in.nextInt();
      int p = in.nextInt();
      Calculator myCalculator = new Calculator();
      try {
        int ans = myCalculator.power(n, p);
        System.out.println(ans);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    in.close();

  }

}
