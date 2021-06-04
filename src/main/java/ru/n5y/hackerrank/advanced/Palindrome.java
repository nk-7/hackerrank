package ru.n5y.hackerrank.advanced;

public class Palindrome {
  public static void main(String[] args) {
    System.out.println(check(11));
  }

  private static boolean check(int x) {
    int reversed = 0;
    int n = x;
    while (n > 0) {
      reversed = reversed * 10 + n % 10;
      n = n / 10;
    }
    return reversed == x;
  }

}
