package ru.n5y.hackerrank.datastructures;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Java1DArray2 {

  public static boolean canWin(int leap, int[] game) {

    return test(leap, game, new HashSet<>(), 0);
  }

  private static boolean test(int leap, int[] game, Set<Integer> visited, int position) {
    visited.add(position);
    if (game[position] != 0) {
      return false;
    }
    if (position == game.length - 1 || position + leap >= game.length) {
      return true;
    }
    if (position > 0 && !visited.contains(position - 1) && test(leap, game, visited, position - 1)) {
      return true;
    }
    if (!visited.contains(position + 1) && test(leap, game, visited, position + 1)) {
      return true;
    }
    return !visited.contains(position + leap) && test(leap, game, visited, position + leap);

  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int q = scan.nextInt();
    while (q-- > 0) {
      int n = scan.nextInt();
      int leap = scan.nextInt();

      int[] game = new int[n];
      for (int i = 0; i < n; i++) {
        game[i] = scan.nextInt();
      }

      System.out.println((canWin(leap, game)) ? "YES" : "NO");
    }
    scan.close();
  }
}