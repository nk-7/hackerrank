package ru.n5y.hackerrank.datastructures;

import java.util.*;

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

    private final PriorityQueue<Student> queue;

    public Priorities() {
      this.queue = new PriorityQueue<>(Comparator
          .comparing(Student::getCGPA).reversed()
          .thenComparing(Student::getName)
          .thenComparing(Student::getID)
      );
    }

    List<Student> getStudents(List<String> events) {
      events.stream()
          .map(Command::fromLine)
          .forEach(c -> c.visit(queue));
      return new ArrayList<>(queue);
    }

    private interface Command {
      void visit(PriorityQueue<Student> queue);

      static Command fromLine(String line) {
        if (line.startsWith("ENTER")) {
          final String[] split = line.split("\\s+");
          final String name = split[1];
          final double cpga = Double.parseDouble(split[2]);
          final int id = Integer.parseInt(split[3]);
          return new Enter(new Student(id, name, cpga));
        } else {
          return new Served();
        }
      }
    }

    private static class Served implements Command {

      @Override
      public void visit(PriorityQueue<Student> queue) {
        final Student poll = queue.poll();
        System.out.println("Served: " + poll);
      }
    }

    private static class Enter implements Command {

      private final Student student;

      private Enter(Student student) {
        this.student = student;
      }

      @Override
      public void visit(PriorityQueue<Student> queue) {
        queue.add(student);
      }
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

    @Override
    public String toString() {
      return "Student{" +
          "id=" + id +
          ", name='" + name + '\'' +
          ", cgpa=" + cgpa +
          '}';
    }
  }
}
