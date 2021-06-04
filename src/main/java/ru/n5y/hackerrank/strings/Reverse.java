package ru.n5y.hackerrank.strings;

public class Reverse {
  public static void main(String[] args) {
    final String x = "maam";

    boolean miss = false;
    for (int i = 0; i < x.length() / 2; i++) {
      if (x.charAt(i) != x.charAt(x.length() - i - 1)) {
        miss = true;
        break;
      }
    }
    System.out.println(miss ? "No" : "Yes");

  }

}
