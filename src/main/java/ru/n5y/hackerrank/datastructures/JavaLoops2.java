package ru.n5y.hackerrank.datastructures;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JavaLoops2 {

  public static void main(String[] argh) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int i = 0; i < t; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int n = in.nextInt();

      int[] row = new int[n];

      for (int l = 0; l < n; l++) {
        int res = a;
        for (int j = 0; j <= l; j++) {
          res += Math.pow(2, j) * b;
        }
        row[l] = res;
      }
      System.out.println(Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
    in.close();
  }
}
