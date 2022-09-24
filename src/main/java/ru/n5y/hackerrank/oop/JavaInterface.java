package ru.n5y.hackerrank.oop;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaInterface {
  interface AdvancedArithmetic {
    int divisor_sum(int n);
  }

  static class MyCalculator implements AdvancedArithmetic {

    @Override
    public int divisor_sum(int n) {
      final Set<Integer> divisors = new HashSet<>();
      for (int d = n / 2; d > 0; d--) {
        if (n % d == 0) {
          divisors.add(d);
        }
      }
      return divisors.stream().reduce(n, Integer::sum);
    }
  }


  public static void main(String[] args) {
    MyCalculator my_calculator = new MyCalculator();
    System.out.print("I implemented: ");
    ImplementedInterfaceNames(my_calculator);
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.print(my_calculator.divisor_sum(n) + "\n");
    sc.close();
  }

  static void ImplementedInterfaceNames(Object o) {
    Class[] theInterfaces = o.getClass().getInterfaces();
    for (int i = 0; i < theInterfaces.length; i++) {
      String interfaceName = theInterfaces[i].getName();
      System.out.println(interfaceName);
    }
  }


}
