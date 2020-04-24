package com.jikaigg.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo3 {
    public static void main(String[] args) {
        List<String> l = Arrays.asList("hello","world");
        List<String[]> collect = l.stream().map(s -> s.split("")).collect(Collectors.toList());

        l.stream().flatMap(s->Arrays.stream(s.split(""))).forEach(System.out::println);
    }
}
