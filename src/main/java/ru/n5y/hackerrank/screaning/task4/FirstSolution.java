package ru.n5y.hackerrank.screaning.task4;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This solution was writen in short time. This is a prototype just to solve problem on hackerrank.
 */
public class FirstSolution {
  public static void main(String[] args) throws IOException, InterruptedException {
    System.out.println(getArticleTitles("saintamh"));
  }

  public static List<String> getArticleTitles(String author) throws IOException {
    try {
      final List<Page> pages = new ArrayList<>();
      final Page page = getPage(author);
      pages.add(page);

      //collect all pages
      for (int i = page.page; i < page.total_pages; i++) {
        pages.add(getPage(author, i));
      }
      final List<String> articles = pages.stream().flatMap(p -> p.getData().stream())
          .filter(a -> a.story_title != null || a.title != null)
          .map(a -> a.title == null ? a.story_title : a.title)
          .collect(Collectors.toList());

      return articles;
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    return Collections.emptyList();
  }

  private static Page getPage(String author) throws IOException, InterruptedException {

    final HttpURLConnection con = (HttpURLConnection) URI.create(String.format("https://jsonmock.hackerrank.com/api/articles?author=%s", author)).toURL().openConnection();
    con.setRequestMethod("GET");
    return new Gson().fromJson(new InputStreamReader(con.getInputStream()), Page.class);
  }

  private static Page getPage(String author, int page) throws IOException, InterruptedException {
    final HttpURLConnection con = (HttpURLConnection) URI.create(String.format("https://jsonmock.hackerrank.com/api/articles?author=%s&page=%d", author, page))
        .toURL()
        .openConnection();
    con.setRequestMethod("GET");
    return new Gson().fromJson(new InputStreamReader(con.getInputStream()), Page.class);
  }

  public static class Page {

    private Integer page;
    private Integer total_pages;
    private List<Article> data;

    public Integer getPage() {
      return page;
    }

    public void setPage(Integer page) {
      this.page = page;
    }

    public Integer getTotal_pages() {
      return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
      this.total_pages = total_pages;
    }

    public List<Article> getData() {
      return data;
    }

    public void setData(List<Article> data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return "Page{" +
          "page=" + page +
          ", total_pages=" + total_pages +
          ", data=" + data +
          '}';
    }
  }

  public static class Article {
    private String title;
    private String story_title;

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    @Override
    public String toString() {
      return "Article{" +
          "title='" + title + '\'' +
          ", story_title='" + story_title + '\'' +
          '}';
    }
  }

}
