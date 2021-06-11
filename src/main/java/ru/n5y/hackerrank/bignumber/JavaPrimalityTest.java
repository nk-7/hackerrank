package ru.n5y.hackerrank.bignumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class JavaPrimalityTest {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String n = bufferedReader.readLine();

    final BigInteger bi = new BigInteger(n);
    System.out.println(bi.isProbablePrime(100) ? "prime" : "not prime");

    bufferedReader.close();
  }
}
