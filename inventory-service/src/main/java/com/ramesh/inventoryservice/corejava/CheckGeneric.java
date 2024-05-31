package com.ramesh.inventoryservice.corejava;

public class CheckGeneric {
  public static void main(String[] args) {

    BoxGen<String> stringBox = new BoxGen<>();
    stringBox.setContent("Hello welcome to my test content");
    System.out.println(stringBox.getContent());

    BoxGen<Integer> integerBoxGen = new BoxGen<>();
    integerBoxGen.setContent(100);
    System.out.println(integerBoxGen.getContent());

    BoxGen<Boolean> booleanBoxGen = new BoxGen<>();
    booleanBoxGen.setContent(true);
    System.out.println(booleanBoxGen.getContent());

    BoxGen<Double> doubleBoxGen = new BoxGen<>();
    doubleBoxGen.setContent(100.0);
    System.out.println(doubleBoxGen.getContent());

    Integer[] intArray = {1,2,3,4,5};
    printArray(intArray);

    String[] stringArray = {"a","b","c"};
    printArray(stringArray);


  }

 public static<T> void printArray(T[] array){
   for(T t:array){
     System.out.println(t + " ");
   }
 }
}
