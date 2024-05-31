package com.ramesh.discoveryservice.coreJava;

import com.ctc.wstx.shaded.msv_core.grammar.relaxng.datatype.CompatibilityDatatypeLibrary;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class datasts {

  public static void main(String[] args) {

    Integer[] intVal = {1,2,3,4,5};

   // Arrays.asList(intVal).stream().filter(i->i%2==1 ).sorted(Comparator.reverseOrder()).forEach(System.out::println);

    String[] strName = {"ramesh","ravi","kiran","suresh"};

    /*
    Stream.of(strName)
        .sorted(Comparator.reverseOrder())
        .filter(i->i.startsWith("r"))
        .filter(res->res.length()>5)
        .forEach(System.out::println);
     */
    //Stream and Collections

    List<Book> bookList = new ArrayList<>();
    bookList.add(new Book("Ramesh Pongiannan","PHP",330,TypeBook.TEXT));
    bookList.add(new Book("Kavin Kumar","KAVA",440,TypeBook.EBOOK));
    bookList.add(new Book("Ramesh Rohit","AI",139,TypeBook.THRILLER));
    bookList.add(new Book("Laxshana","DOTNET",380,TypeBook.TEXT));
    bookList.add(new Book("Amutha Ganapathi","Python",740,TypeBook.EBOOK));
    bookList.add(new Book("Maha papa","PHP",280,TypeBook.TEXT));
/*
    List<String> resultBook =  bookList.stream().filter(t->t.getType()==TypeBook.TEXT)
        .sorted(Comparator.comparing(Book::getPage).reversed())
        .map(Book::getAuthorName)
        .collect(Collectors.toList());
    System.out.println(resultBook.toString());


    Map<TypeBook, List<Book>> listBook =  bookList.stream()
        .filter(re->re.getPage()>400)
        .sorted(Comparator.comparing(Book::getPage).reversed())
          .collect(Collectors.groupingBy(Book::getType));
    System.out.println(listBook.toString());

 */


    List<String> listName = Arrays.asList("Ramesh Pongiannan","Kavin Kumar","Ramesh Rohit","Laxshana","Amutha Ganapathi","Maha papa");

    listName.stream().filter(i->i.contains("ana"))
        .map(String::length)
        //.filter(res->res.length()>9)
        .filter(res->res>9)
        .forEach(System.out::println);

    String[] strSt = {"hellohello"};
   /*
    List<IntStream> res = Arrays.asList(strSt).stream()
        .map(s -> Arrays.stream(s.split(""))
            .filter(s1 -> s1.equalsIgnoreCase("h"))
        .collect(Collectors.toList());
    */

  }
}
