package com.jikaigg.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo2 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("yao","ji","kai","shi","meng","kuang");
        List<String> i = list1.stream().filter(s -> s.contains("i")).collect(Collectors.toList());
        System.out.println(i);
    }
}
