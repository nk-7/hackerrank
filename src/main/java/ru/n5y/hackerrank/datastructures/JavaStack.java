package ru.n5y.hackerrank.datastructures;

import java.util.Scanner;
import java.util.Stack;

public class JavaStack {
  public static void main(String[] argh) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNext()) {
      String input = sc.next();
      System.out.println(validate(input));
    }
  }

  private static boolean validate(String line) {
    if (line.isEmpty()) {
      return true;
    }
    final char[] chars = line.toCharArray();
    final Stack<Character> stack = new Stack<>();
    for (char c : chars) {
      switch (c) {
        case '(':
        case '{':
        case '[':
          stack.push(c);
          break;
        case ')':
          if (stack.isEmpty() || stack.pop() != '(') {
            return false;
          }
          break;
        case '}':
          if (stack.isEmpty() || stack.pop() != '{') {
            return false;
          }
          break;
        case ']':
          if (stack.isEmpty() || stack.pop() != '[') {
            return false;
          }
          break;
        default:
          // do nothing
      }
    }
    return stack.isEmpty();
  }

}
