package com.pages;

import com.microsoft.playwright.Page;

public class SearchResultPage {

  private Page page;

  public SearchResultPage(Page page) {
    this.page = page;
  }

  private String searchPageHeader = "div#content h1";

  public String getSearchPageHeader() {
    return page.textContent(searchPageHeader);
  }
}
