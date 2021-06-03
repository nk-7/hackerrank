package ru.n5y.hackerrank.screaning.task4.good.service;

import java.io.IOException;
import java.util.Optional;
import ru.n5y.hackerrank.screaning.task4.good.dto.Page;

public interface PageService {

  Optional<Page> getPage(String author) throws IOException;

  Optional<Page> getPage(String author, int pageNumber) throws IOException;
}
