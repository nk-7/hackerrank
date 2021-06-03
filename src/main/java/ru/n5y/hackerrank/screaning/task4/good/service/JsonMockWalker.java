package ru.n5y.hackerrank.screaning.task4.good.service;

import java.io.IOException;
import ru.n5y.hackerrank.screaning.task4.good.dto.Page;

public interface JsonMockWalker {

  void walk(String author, Visitor visitor) throws IOException;

  interface Visitor {
    void visit(Page page);
  }

}
