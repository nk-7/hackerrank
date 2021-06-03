package ru.n5y.hackerrank.screaning.task2;

import java.util.Arrays;
import java.util.List;

/**
 * Naive decision.
 * <p>
 * Complexity of this solution is about O(n*n) that because some tests was failed with timeout.
 */
public class NaiveSolution {
  public static void main(String[] args) {
    System.out.println(minX(Arrays.asList(-5, 4, -2, 3, 1, -1, -6, -1, 0, 5)));
  }

  public static int minX(List<Integer> arr) {
    int minSum = 0;

    for (int i = 0; i < arr.size(); i++) {
      int sum = 0;
      for (int j = 0; j <= i; j++) {
        sum += arr.get(j);
      }
      if (sum < minSum) {
        minSum = sum;
      }
    }
    return 1 - minSum;
  }
}
