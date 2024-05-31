package com.ramesh.discoveryservice.coreJava;


public class Book {

  private String authorName;
  private String title;

  private int page;

  private TypeBook type;

  public String getAuthorName() {
    return authorName;
  }



  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public TypeBook getType() {
    return type;
  }

  public void setType(TypeBook type) {
    this.type = type;
  }

  public Book(String authorName, String title, int page, TypeBook type) {
    this.authorName = authorName;
    this.title = title;
    this.page = page;
    this.type = type;
  }

  @Override
  public String toString() {
    return "Book{" +
        "authorName='" + authorName + '\'' +
        ", title='" + title + '\'' +
        ", page=" + page +
        ", type=" + type +
        '}';
  }
}
