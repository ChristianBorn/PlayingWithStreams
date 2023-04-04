package org.example;

import org.example.csv_processing.CsvReader;
import org.example.csv_processing.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        String string = "Hello World";
        int[] unsortedIntegers = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        IntStream intStream = StreamGenerators.generateStreamFromRangeExclusive(0, 10);
        IntStream intStreamInclusive = StreamGenerators.generateStreamFromRangeInclusive(0, 10);
        List<Car> listOfCars = List.of(
                new Car("BWM", 164),
                new Car("Mercedes", 123),
                new Car("Kia", 523),
                new Car("Audi", 1123),
                new Car("BMW", 143),
                new Car("Renault", 103)
        );

        CsvReader reader = new CsvReader("src/main/resources/csv/students.csv");
        reader.cleanAndPrintFile();
        List<Student> listOfStudents= reader.createStudentsFromStream();
        System.out.println("List of students from CSV: \n" + listOfStudents);
        System.out.println("List of students from CSV sorted by name: \n" + listOfStudents.stream().sorted().toList());
        System.out.println("List of students from CSV sorted by age: \n" + listOfStudents.stream().sorted(Comparator.comparing(Student::getAge)).toList());
        System.out.println(IntermediateOperations.productIntegerList(unsortedIntegers));
        System.out.println("Sum of integer array: " + IntermediateOperations.sumIntegerList(unsortedIntegers));
        System.out.println(Arrays.toString(IntermediateOperations.sortIntegerList(unsortedIntegers)));
        System.out.println(IntermediateOperations.getCarWithMostHP(listOfCars));
        System.out.println(IntermediateOperations.sortCarsByManufacturer(listOfCars).toString());
        System.out.println(Arrays.toString(intStream.toArray()));
        System.out.println(Arrays.toString(intStreamInclusive.toArray()));
        System.out.println(Arrays.toString(StreamGenerators.splitStringIntoStream(" ", string).toArray()));
        System.out.println(StreamGenerators.splitStringIntoStream(" ", string).skip(1).findAny());
        System.out.println(IntermediateOperations.calculateFibonacci(100));
    }
}
