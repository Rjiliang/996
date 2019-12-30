package com.cherry.stream;


import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流的四种构建形式
 */
public class StreamConstructor {
    /**
     * 由数值直接构建流
     */
    @Test
    public void streamForValue() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        integerStream.forEach(System.out::println);
    }

    /**
     * 由数组来构建流
     */
    @Test
    public void streamForArray() {
        int[] numbers = {1,2,3,4,5,6,7};
        IntStream intStream = Arrays.stream(numbers);
        intStream.forEach(System.out::println);
    }

    /**
     * 通过文件生成流
     * @throws IOException
     */
    @Test
    public void streamForFile() throws IOException {
        Stream<String> stream = Files.lines(Paths.get("E:\\src\\git\\996\\src\\main\\java" +
                "\\com\\cherry\\stream\\StreamConstructor.java"));
        stream.forEach(System.out::println);
    }

    /**
     * 通过函数生成流（无限流）
     */
    @Test
    public void streamFormFunction() {
//        Stream<Integer> stream = Stream.iterate(0, n -> n + 2);
        Stream<Double> stream = Stream.generate(Math::random);
        stream.limit(100).forEach(System.out::println);
    }

}
