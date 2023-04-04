package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface IntermediateOperations {

    static List<String> makeUppercase(List<String> stringList) {
        return stringList.stream()
                .filter(singleString -> !singleString.isBlank())
                .map(String::toUpperCase)
                .toList();
    }

    static String calculateFibonacci(int sizeOfFibonacci) {
        return Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(sizeOfFibonacci)
                .map(t -> t[0])
                .map(String::valueOf) // convert to string
                .collect(Collectors.joining(", "));
    }

    static List<String> sortListOfStrings(List<String> stringList) {
        return stringList.stream().sorted(String::compareTo).toList();
    }

    static int[] sortIntegerList(int[] listOfIntegers) {
        return Arrays.stream(listOfIntegers).sorted().toArray();
    }

    static int sumIntegerList(int[] listOfIntegers) {
        return Arrays.stream(listOfIntegers).sum();
    }

    static int productIntegerList(int[] listOfIntegers) {
        return Arrays.stream(listOfIntegers).reduce(1, (subtotal, element) -> subtotal * element);
    }

    static List<Car> sortCarsByManufacturer(List<Car> listOfCars) {
        return listOfCars.stream().sorted().toList();
    }

    static Optional<Car> getCarWithMostHP(List<Car> listOfCars) {
        return listOfCars.stream()
                .max(Comparator.comparingInt(Car::getHorsepower));
    }
}
