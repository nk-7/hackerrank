package ru.n5y.hackerrank.introduction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EndOfFile {
  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    final List<String> strings = new ArrayList<>();
    try (final Scanner scanner = new Scanner(System.in)) {
      while (scanner.hasNext()) {
        strings.add(scanner.nextLine());
      }
    }
    for (int i = 0; i < strings.size(); i++) {
      System.out.println(i + 1 + " " + strings.get(i));
    }
  }
}
