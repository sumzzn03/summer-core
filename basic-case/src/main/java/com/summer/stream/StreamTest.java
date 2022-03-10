package com.summer.stream;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamTest {



    public static void main(String[] args) {
        String[] arrayOfWorlds = {"Hello", "World"};
        Stream<String> stream = Arrays.stream(arrayOfWorlds);

        List<String> wordList = Lists.newArrayList();
        wordList.add("Hello");
        wordList.add("World");

        Stream<String> stringStream = wordList.stream().map(item -> item.split("")).map(Arrays::stream).flatMap(item -> item);
//        wordList.stream().map(item -> item.split("")).flatMap(Arrays::stream).flatMap(item -> item);




        Function<String, Runnable> function = item -> {
            return () -> {};
        };
    }
}
