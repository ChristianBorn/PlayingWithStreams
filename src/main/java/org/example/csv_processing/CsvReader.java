package org.example.csv_processing;

import lombok.Data;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Data
public class CsvReader {
    private Path path;
    private String fileContent;
    public CsvReader(String pathToFile) {
        this.path = Path.of(pathToFile);
    }

    public void cleanAndPrintFile() {
        this.fileContent = cleanFile().collect(Collectors.joining("\n"));
        System.out.println(fileContent);
    }

    public List<Student> createStudentsFromStream() {
        return cleanFile().map(line -> {
            String[] splitLine = line.split(",");
            return new Student(
                    Integer.parseInt(splitLine[0]),
                    splitLine[1],
                    splitLine[2],
                    Integer.parseInt(splitLine[3]));
        }).toList();
    }

    private Stream<String> readFile() {
        try {
            return Files.lines(path, StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            System.out.println("File not found under path: " + path.toString());
            return Stream.empty();
        }
    }

    private Stream<String> cleanFile() {
        return readFile()
                .skip(1)
                .filter(line -> !line.isBlank())
                .distinct();
    }
}

