package ru.n5y.hackerrank.screaning.task4.good;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ru.n5y.hackerrank.screaning.task4.good.service.CurrentThreadJsonMockWalker;
import ru.n5y.hackerrank.screaning.task4.good.service.JsonMockPageService;

public class GoodSolution {
  public static void main(String[] args) throws IOException, InterruptedException {
    System.out.println(getArticleTitles("saintamh"));
  }

  public static List<String> getArticleTitles(String author) throws IOException {
    final List<String> articles = new ArrayList<>();

    new CurrentThreadJsonMockWalker(new JsonMockPageService()).walk(author, page -> {
      if (page.getData() != null) {
        page.getData().stream().filter(a -> a.getTitle() != null || a.getStory_title() != null)
            .map(a -> a.getTitle() != null ? a.getTitle() : a.getStory_title())
            .forEach(articles::add);
      }
    });
    return articles;
  }

}
