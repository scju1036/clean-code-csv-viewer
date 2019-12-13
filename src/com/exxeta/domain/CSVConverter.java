package com.exxeta.domain;

import com.exxeta.exception.EmptyFileException;

import java.util.ArrayList;
import java.util.List;

public class CSVConverter {

    public static CSVData convert(List<String> content) throws EmptyFileException{
        CSVData csvData = new CSVData();
        if (content.size() > 0) {
            csvData.getHeader().addAll(List.of(content.get(0).split(";")));
            for (int i = 1; i < content.size(); i++) {
                csvData.getContent().put(i, new ArrayList(List.of(content.get(i).split(";"))));
            }
        } else {
            throw new EmptyFileException();
        }
        return csvData;
    }
}
