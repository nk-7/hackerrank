package ru.n5y.hackerrank.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtraction {

  public static void main(String[] args) {

    final Pattern pattern = Pattern.compile("(?:<([^>]+)>)+(.*?)(?:</\\1+>)+");
    Scanner in = new Scanner(System.in);
    int testCases = 1;
//    int testCases = Integer.parseInt(in.nextLine());
    while (testCases > 0) {
      String line = in.nextLine();
      final Matcher matcher = pattern.matcher(line);
      boolean found = false;
      while (matcher.find()) {
        System.out.println(matcher.group(2));
        found = true;
      }
      if(!found){
        System.out.println("None");
      }
      testCases--;
    }
  }
}
