package ru.n5y.hackerrank.screaning.task4.good.dto;

public class Article {
  private String title;
  private String story_title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getStory_title() {
    return story_title;
  }

  public void setStory_title(String story_title) {
    this.story_title = story_title;
  }

  @Override
  public String toString() {
    return "Article{" +
        "title='" + title + '\'' +
        ", story_title='" + story_title + '\'' +
        '}';
  }
}
