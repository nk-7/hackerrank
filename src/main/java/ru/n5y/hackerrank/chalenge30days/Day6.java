package ru.n5y.hackerrank.chalenge30days;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/** @author Nikolay Kuleshov */
public class Day6 {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      final int n = scanner.nextInt();
      final List<String> lines = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        lines.add(makeOutputLine(scanner.next()));
      }
      lines.forEach(System.out::println);
    }
  }

  private static String makeOutputLine(String inLine) {
    final char[] chars = inLine.toCharArray();
    final List<Character> odds = new ArrayList<>();
    final List<Character> evens = new ArrayList<>();

    for (int i = 0; i < chars.length; i++) {
      if (i % 2 == 0) {
        evens.add(chars[i]);
      } else {
        odds.add(chars[i]);
      }
    }
    return evens.stream().map(Object::toString).collect(Collectors.joining()) + " " + odds.stream().map(Object::toString).collect(Collectors.joining());
  }
}
