package com.summer.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {

        List<Integer> listInteger =new ArrayList<Integer>();
        List<String> listString =new ArrayList<String>();
//        printCollection(listInteger);
//        printCollection(listString);
    }

    public static void printCollection(Collection<Object> collection){
        for(Object obj:collection){
            System.out.println(obj);
        }
    }

    public static void foo(List<? extends Number> list){
        //The method add(capture#1-of ? extends Number) in the type List<capture#1-of ? extends Number>
        //is not applicable for the arguments (Integer)
//        list.add(new Integer(2));  // 编译通过么？ Why ?
    }

    public static void bar(List<? super Number> l){
        l.add(new Integer(2));  // 编译通过么？ Why ?
        l.add(new Float(2));    // ok?
    }

}
