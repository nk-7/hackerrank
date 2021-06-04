package ru.n5y.hackerrank.strings;


public class Anagrams {

  public static void main(String[] args) {
    System.out.println(isAnagram("abc", "abd"));
  }

  static boolean isAnagram(String a, String b) {
    final char[] aChars = a.toLowerCase().toCharArray();
    final char[] bChars = b.toLowerCase().toCharArray();
    java.util.Arrays.sort(aChars);
    java.util.Arrays.sort(bChars);
    if (aChars.length != bChars.length) {
      return false;
    }

    for (int i = 0; i < aChars.length; i++) {
      if (aChars[i] != bChars[i]) {
        return false;
      }
    }

    return true;
  }

}
