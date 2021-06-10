package ru.n5y.hackerrank.strings;

import java.util.Scanner;

public class SubstringsComparison {
  public static String getSmallestAndLargest(String s, int k) {
    String smallest = "";
    String largest = "";

    // Complete the function
    // 'smallest' must be the lexicographically smallest substring of length 'k'
    // 'largest' must be the lexicographically largest substring of length 'k'

    if (s.length() <= k) {
      smallest = s;
      largest = s;
    } else {
      for (int i = 0; i <= s.length() - k; i++) {
        final String candidate = s.substring(i, i + k);
        if (grater(largest, candidate)) {
          largest = candidate;
        }
        if (grater(candidate, smallest)) {
          smallest = candidate;
        }
      }

    }

    return smallest + "\n" + largest;
  }

  private static boolean grater(String x, String y) {
    if (x.equals("") || y.equals("")) {
      return true;

    }
    final char[] a1 = x.toCharArray();
    final char[] a2 = y.toCharArray();
    for (int i = 0; i < a1.length; i++) {
      if (a2[i] > a1[i]) {
        return true;
      } else if (a2[i] < a1[i]) {
        return false;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = scan.next();
    int k = scan.nextInt();
    scan.close();

    System.out.println(getSmallestAndLargest(s, k));
  }
}
