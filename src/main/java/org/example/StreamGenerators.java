package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamGenerators {

    private StreamGenerators() {}
    public static Stream<String> generateEmptyStream() {
        return Stream.empty();
    }

    public static Stream<String> generateStreamFromArray(String[] stringArray) {
        return Arrays.stream(stringArray);
    }

    public static Stream<String> generateStreamWithFixedSize(String streamEntry, int streamSize) {
        return Stream.generate(() -> streamEntry).limit(streamSize);
    }

    public static Stream<Integer> generateStreamWithFixedSize2(int begin, int streamSize) {
        return Stream.iterate(begin, n -> n + 1).limit(streamSize); // Generates a stream beginning at "begin" and incrementing from there until "streamsize" is reached
    }

    public static IntStream generateStreamFromRangeExclusive(int start, int exclusiveEnd) {
        return IntStream.range(start, exclusiveEnd);
    }

    public static IntStream generateStreamFromRangeInclusive(int start, int inclusiveEnd) {
        return IntStream.rangeClosed(start, inclusiveEnd);
    }

    public static Stream<String> splitStringIntoStream(String regexPattern, String stringToSplit) {
        return Pattern.compile(regexPattern).splitAsStream(stringToSplit);
    }

    public static Stream<String> readFileIntoStream(String filepath) {
        Path path = Paths.get(filepath);
        try {
            return Files.lines(path, StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            return Stream.empty();
        }
    }
}
