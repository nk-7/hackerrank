 package ru.n5y.hackerrank.chalenge30days;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day11 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    final int[][] arr = new int[6][6];

    for (int i = 0; i < 6; i++) {
      final String[] s = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
      for (int j = 0; j < 6; j++) {
        arr[i][j] = Integer.parseInt(s[j].trim());
      }
    }

    int max = Integer.MIN_VALUE;
    for (int line = 0; line < arr[0].length - 2; line++) {
      for (int col = 0; col < arr.length - 2; col++) {
        final int sum = sum(arr[line], arr[line + 2], arr[line + 1][col + 1], col, col + 2);
        if (sum > max) {
          max = sum;
        }
      }
    }
    System.out.println(max);
    bufferedReader.close();
  }

  public static int sum(int[] top, int[] bottom, int center, int begin, int end) {
    int sum = center;
    for (int i = begin; i <= end; i++) {
      sum += top[i];
      sum += bottom[i];
    }
    return sum;
  }
}
