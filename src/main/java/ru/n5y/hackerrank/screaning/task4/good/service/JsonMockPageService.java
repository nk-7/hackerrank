package ru.n5y.hackerrank.screaning.task4.good.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;
import java.util.Optional;
import ru.n5y.hackerrank.screaning.task4.good.dto.Page;

/**
 * This is hardcoded implementation to work only with `https://jsonmock.hackerrank.com/api/articles`.
 */
public final class JsonMockPageService implements PageService {
  private static final String HTTP_GET = "GET";
  private static final int HTTP_CODE_200 = 200;
  private static final String AUTHOR_URL_TEMPLATE = "https://jsonmock.hackerrank.com/api/articles?author=%s";
  private static final String AUTHOR_PAGE_URL_TEMPLATE = "https://jsonmock.hackerrank.com/api/articles?author=%s&page=%d";

  private final Gson gson;

  public JsonMockPageService() {
    this.gson = new GsonBuilder().create();
  }

  @Override
  public Optional<Page> getPage(String author) throws IOException {
    Objects.requireNonNull(author, "'author' should not be null.");
    return get(String.format(AUTHOR_URL_TEMPLATE, author));
  }

  @Override
  public Optional<Page> getPage(String author, int pageNumber) throws IOException {
    Objects.requireNonNull(author, "'author' should not be null.");
    return get(String.format(AUTHOR_PAGE_URL_TEMPLATE, author, pageNumber));
  }

  private Optional<Page> get(String urlString) throws IOException {
    final URL url = new URL(urlString);
    final URLConnection urlConnection = url.openConnection();
    if (urlConnection instanceof HttpURLConnection) {
      HttpURLConnection connection = (HttpURLConnection) urlConnection;
      connection.setRequestMethod(HTTP_GET);

      final int code = connection.getResponseCode();
      if (code != HTTP_CODE_200) {
        //todo need logging
        return Optional.empty();
      }
      return Optional.ofNullable(gson.fromJson(new InputStreamReader(connection.getInputStream()), Page.class));
    } else {
      //todo need logging
      throw new IllegalStateException(String.format("Unexpected type of URL.openConnection. Expected 'HttpURLConnection' but was '%s'.", urlConnection.getClass().getName()));
    }
  }
}
