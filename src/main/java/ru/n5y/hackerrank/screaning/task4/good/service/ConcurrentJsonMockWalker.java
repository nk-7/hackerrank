package ru.n5y.hackerrank.screaning.task4.good.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import ru.n5y.hackerrank.screaning.task4.good.dto.Page;

public final class ConcurrentJsonMockWalker implements JsonMockWalker {
  private final PageService pageService;

  public ConcurrentJsonMockWalker(PageService pageService) {
    Objects.requireNonNull(pageService, "'pageService' should not be null.");
    this.pageService = pageService;
  }

  @Override
  public void walk(String author, Visitor visitor) throws IOException {
    final Optional<Page> mayBePage = pageService.getPage(author);

    if (mayBePage.isPresent()) {
      final Page page = mayBePage.get();
      visitor.visit(page);
      final Integer currentPageNum = page.getPage();
      final Integer total_pages = page.getTotal_pages();

      final List<CompletableFuture<?>> scheduledFutures = new ArrayList<>();
      for (int i = currentPageNum + 1; i < total_pages; i++) {
        final int nextPageNum = i;
        scheduledFutures.add(CompletableFuture.supplyAsync(() -> getPageSilent(author, nextPageNum)).thenAccept(nextPage -> nextPage.ifPresent(visitor::visit)));
      }
      scheduledFutures.forEach(CompletableFuture::join);

    }
  }

  private Optional<Page> getPageSilent(String author, int nextPageNum) {
    try {
      return pageService.getPage(author, nextPageNum);
    } catch (IOException e) {
      return Optional.empty();
    }
  }
}
