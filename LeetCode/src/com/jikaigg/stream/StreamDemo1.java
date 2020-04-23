package com.jikaigg.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo1 {
    public static void main(String[] args) {
        //列表、流操作
        //新建一个String类型元素的列表["yaojikai", "shimengyu", "yaokai", "shiyu"]
        List<String> strings = Arrays.asList("yaojikai", "shimengyu", "yaokai", "shiyu");
        //获取列表的流。过滤(留下以s字符串开头的元素)。用String类下的转换大写方法把所有元素(上一步中留下的元素)。排序(默认方式。再转换回列表
        List<String> list = strings.stream().filter(s->s.startsWith("s")).map(String::toUpperCase).sorted().collect(Collectors.toList());
        System.out.println(list);
        //字符数组、流操作
        String[] strs = {"yaojikai", "shimengyu", "yaokai", "shiyu"};
        //获取字符数组的流。过滤(留下以s字符串开头的元素)。用String类下的转换大写方法把所有元素(上一步中留下的元素)。排序(默认方式。再转换回列表
        List<String> list2 = Stream.of(strs).filter(s -> s.startsWith("s")).map(String::toUpperCase).sorted().collect(Collectors.toList());
        System.out.println(list2);

        //求列表中所有元素的平方数
        List<Integer> ints = Arrays.asList(1,2,3,4,5);
        //获取列表的流。操作集合中的数进行平方，在转换回列表
        List<Integer> list3 = ints.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println(list3);


    }
}
