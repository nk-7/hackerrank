package ru.n5y.hackerrank.introduction;

import java.util.Scanner;

public class StaticInitializerBlock {

  private static boolean flag = false;
  private static final int B;
  private static final int H;

  static {
    try (Scanner scanner = new Scanner(System.in)) {
      B = scanner.nextInt();
      H = scanner.nextInt();
      if (H <= 0 || B <= 0) {
        System.out.println("java.lang.Exception: Breadth and height must be positive");
      } else {
        flag = true;
      }
    }
  }

  public static void main(String[] args) {
    if (flag) {
      int area = B * H;
      System.out.print(area);
    }

  }//end of main

}//end of cl


