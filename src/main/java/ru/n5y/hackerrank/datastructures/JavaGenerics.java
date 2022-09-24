package ru.n5y.hackerrank.datastructures;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class JavaGenerics {
  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    printArray(new Integer[]{1, 2, 3});
    printArray(new String[]{"Hello", "World"});
  }

  private static <T> void printArray(T[] objects) {
    final String line = Arrays.stream(objects).map(Objects::toString).collect(Collectors.joining(System.lineSeparator()));
    System.out.println(line);

  }


}
