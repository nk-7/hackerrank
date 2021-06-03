package ru.n5y.hackerrank.screaning.task4.good.service;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import ru.n5y.hackerrank.screaning.task4.good.dto.Page;

public final class CurrentThreadJsonMockWalker implements JsonMockWalker {
  private final PageService pageService;

  public CurrentThreadJsonMockWalker(PageService pageService) {
    Objects.requireNonNull(pageService, "'pageService' should not be null.");
    this.pageService = pageService;
  }

  @Override
  public void walk(String author, Visitor visitor) throws IOException {
    visitAndNext(author, visitor, pageService.getPage(author));
  }

  private void walk(String author, int pageNumber, Visitor visitor) throws IOException {
    visitAndNext(author, visitor, pageService.getPage(author, pageNumber));
  }

  private void visitAndNext(String author, Visitor visitor, Optional<Page> mayBePage) throws IOException {
    if (mayBePage.isPresent()) {
      final Page page = mayBePage.get();
      visitor.visit(page);
      if (hasNextPage(page)) {
        walk(author, page.getPage() + 1, visitor);
      }
    }
  }

  private boolean hasNextPage(Page page) {
    return page.getPage() != null && page.getTotal_pages() != null && page.getPage() < page.getTotal_pages();
  }
}
