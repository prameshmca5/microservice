package com.ramesh.inventoryservice.corejava;

public class ArrayCom {

  public static void main(String[] args) {
    Integer[] intArr1  = {1,2,3,4,5};
    Integer[] intArr2  = {3,4,5,7,8};
    for(Integer i:intArr1){
       for (Integer j:intArr2){
         if(i.equals(j)){
           System.out.println(i);
         }
       }
    }
  }
}
