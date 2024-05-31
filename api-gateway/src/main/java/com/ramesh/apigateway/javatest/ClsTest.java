package com.ramesh.apigateway.javatest;

public class ClsTest {

  public static void main(String[] args) {

    final A a = new A(null, null);
    System.out.println(a.i + " "+a.j);
  }
}


class A {
  String i, j;

  public A(String i, String j) {
    this.i = i;
    this.j = j;
  }

}