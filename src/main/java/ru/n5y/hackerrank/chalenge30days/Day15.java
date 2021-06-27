package ru.n5y.hackerrank.chalenge30days;

public class Day15 {
  class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  public Node insert(Node head, int data) {
    if (head == null) {
      return new Node(data);
    }
    Node tail = head;
    while (tail.next != null) {
      tail = tail.next;
    }

    tail.next = new Node(data);
    return head;
  }
}
