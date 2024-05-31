package com.ramesh.apigateway.javatest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class JavaTest2 {

  public static void main(String[] args) {

    String encod = "w4a3d1e1x6";
    Map<String, Integer> encodMap = new LinkedHashMap<>();
    for(int i=0; i<encod.length();i++){
     int intcod = encod.charAt(i)-'0';

       if(intcod>=0 && intcod<=9){
          encodMap.put(String.valueOf(encod.charAt(i-1)), intcod);
       }
    }
    System.out.println(encodMap);


  }
}
