package ru.n5y.hackerrank.datastructures;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaArrayList {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      final int n = in.nextInt();
      final ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        final int d = in.nextInt();
        final ArrayList<Integer> row = new ArrayList<>();
        for (int j = 0; j < d; j++) {
          row.add(in.nextInt());
        }
        matrix.add(row);
      }
      int q = in.nextInt();
      for (int i = 0; i < q; i++) {
        final int x = in.nextInt() - 1;
        final int y = in.nextInt() - 1;
        try {
          final Integer answer = matrix.get(x).get(y);
          System.out.println(answer);
        } catch (IndexOutOfBoundsException ignore) {
          System.out.println("ERROR!");
        }
      }
    }
  }


}
