package ru.n5y.hackerrank.screaning.task4.good.dto;

import java.util.List;

public class Page {

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
