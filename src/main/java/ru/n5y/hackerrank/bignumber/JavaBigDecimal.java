package ru.n5y.hackerrank.bignumber;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class JavaBigDecimal {
  public static void main(String[] args) {
    //Input
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] s = new String[n + 2];
    for (int i = 0; i < n; i++) {
      s[i] = sc.next();
    }
    sc.close();

    //Write your code here

    Arrays.sort(s, 0, n, (o1, o2) -> new BigDecimal(o2).compareTo(new BigDecimal(o1)));

    //Output
    for (int i = 0; i < n; i++) {
      System.out.println(s[i]);
    }
  }

}
