package ru.n5y.hackerrank.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** @author Nikolay Kuleshov */
public class JavaPriorityQueue {
  private final static Scanner scan = new Scanner(System.in);
  private final static Priorities priorities = new Priorities();

  public static void main(String[] args) {
    int totalEvents = Integer.parseInt(scan.nextLine());
    List<String> events = new ArrayList<>();

    while (totalEvents-- != 0) {
      String event = scan.nextLine();
      events.add(event);
    }

    List<Student> students = priorities.getStudents(events);

    if (students.isEmpty()) {
      System.out.println("EMPTY");
    } else {
      for (Student st : students) {
        System.out.println(st.getName());
      }
    }
  }

  static class Priorities {
    List<Student> getStudents(List<String> events) {
      return null;
    }
  }

  static class Student {

    private final int id;
    private final String name;
    private final double cgpa;

    public Student(int id, String name, double cgpa) {
      this.id = id;
      this.name = name;
      this.cgpa = cgpa;
    }

    public int getID() {
      return id;
    }

    public String getName() {
      return name;
    }

    public double getCGPA() {
      return cgpa;
    }
  }
}
