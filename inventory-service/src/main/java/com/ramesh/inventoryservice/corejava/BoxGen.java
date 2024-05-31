package com.ramesh.inventoryservice.corejava;

public class BoxGen <T> {

  private T content;

  public void setContent(T content) {
    this.content = content;
  }

  public T getContent() {
    return content;
  }
}
