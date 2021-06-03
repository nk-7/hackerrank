package ru.n5y.hackerrank.screaning.task2;

import java.util.Arrays;
import java.util.List;

/**
 * Good solution.
 * <p>
 * Complexity of this solution is about O(n).
 */
public class GoodSolution {
  public static void main(String[] args) {
    System.out.println(minX(Arrays.asList(-5, 4, -2, 3, 1, -1, -6, -1, 0, 5)));
  }

  public static int minX(List<Integer> arr) {
    int minSum = 0;
    int currentSum = 0;
    for (Integer integer : arr) {
      currentSum += integer;
      System.out.println(currentSum);
      if (currentSum < minSum) {
        minSum = currentSum;
      }
    }
    return 1 - minSum;
  }
}
