package ru.n5y.hackerrank.datastructures;

import java.util.Scanner;

public class JavaSubArray {
  public static void main(String[] args) {
    final int[] array = readArray();
    int count = 0;
    for (int window = 1; window <= array.length; window++) {
      for (int i = 0; i <= array.length - window; i++) {
        if (sum(array, i, i + window) < 0) {
          count++;
        }
      }
    }
    System.out.println(count);

  }

  private static int[] readArray() {
    try (Scanner in = new Scanner(System.in)) {
      final int n = in.nextInt();
      final int[] array = new int[n];
      for (int i = 0; i < n; i++) {
        array[i] = in.nextInt();
      }
      return array;
    }
  }

  private static int sum(int[] arr, int begin, int end) {
    int sum = 0;
    for (int i = begin; i < end; i++) {
      sum = sum + arr[i];
    }
    return sum;
  }
}
