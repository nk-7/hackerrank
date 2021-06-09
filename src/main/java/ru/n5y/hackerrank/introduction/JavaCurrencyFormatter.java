package ru.n5y.hackerrank.introduction;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class JavaCurrencyFormatter {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    final double payment = scanner.nextDouble();
    scanner.close();

    // Write your code here.
    final String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);

    DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
    symbols.setCurrencySymbol("Rs.");
    DecimalFormat indiaFormat = new DecimalFormat("\u00A4#,##0.00", symbols);
    indiaFormat.setMaximumFractionDigits(2);

    final String india = indiaFormat.format(payment);

    final String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
    final String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

    System.out.println("US: " + us);
    System.out.println("India: " + india);
    System.out.println("China: " + china);
    System.out.println("France: " + france);
  }

}
