package ru.n5y.hackerrank.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

final class MyRegex {
  private static final String DOT = "\\.";
  private static final String OCTET = "(([0-9])|([0-1]?[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))";
  private static final Pattern pattern = Pattern.compile(OCTET + DOT + OCTET + DOT + OCTET + DOT + OCTET);

  public static void main(String[] args) {
    final List<String> ips = readIps();
    ips.stream().map(MyRegex::validate).forEach(System.out::println);
  }

  private static boolean validate(String ip) {
    return pattern.matcher(ip).matches();
  }

  private static List<String> readIps() {
    final List<String> ips = new ArrayList<>();
    try (Scanner scanner = new Scanner(System.in)) {
      while (scanner.hasNextLine()) {
        ips.add(scanner.nextLine());
      }
      return ips;
    }
  }

}
