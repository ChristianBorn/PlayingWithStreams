package org.example;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream intStream = StreamGenerators.generateStreamFromRangeExclusive(0, 10);
        IntStream intStreamInclusive = StreamGenerators.generateStreamFromRangeInclusive(0, 10);
        System.out.println(Arrays.toString(intStream.toArray()));
        System.out.println(Arrays.toString(intStreamInclusive.toArray()));


    }
}
