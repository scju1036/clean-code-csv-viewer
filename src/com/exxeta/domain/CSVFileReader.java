package com.exxeta.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader {

    public static List<String> readFile(String filename) {
        List<String> csv = new ArrayList<>();
        try {
            csv = Files.readAllLines(Path.of(filename));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        csv.removeIf(s -> s.isEmpty());
        return csv;
    }
}
