package ru.n5y.hackerrank.chalenge30days;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day10 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());
    int res = 0;
    int consecutive = 0;
    while (n != 0) {
      if (n % 2 == 1) {
        consecutive++;
      } else {
        if (consecutive > res) {
          res = consecutive;
        }
        consecutive = 0;
      }
      n = n / 2;
    }
    res = Math.max(consecutive, res);

    System.out.println(res);

    bufferedReader.close();
  }
}
