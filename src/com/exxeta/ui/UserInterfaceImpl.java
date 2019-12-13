package com.exxeta.ui;

import com.exxeta.domain.CSVData;

import java.io.IOException;
import java.util.*;

public class UserInterfaceImpl implements UserInterface {

    public void printError(String message) {
        System.out.print(message);
    }

    public void printPage(CSVData csvData, int pageSize, int pageNumber) {
        try {
            int currentIndex = 1 + pageNumber * pageSize;
            int stopCondition =  Math.min(currentIndex + pageSize, csvData.getContent().size() + 1);
            Runtime.getRuntime().exec("clear");
            List<Integer> maxCharactersPerColumn = calculateMaxCharactersPerColumn(csvData, currentIndex, stopCondition);
            printLine(csvData.getHeader(), maxCharactersPerColumn);
            printSeparator(maxCharactersPerColumn);
            printContent(csvData.getContent(), currentIndex, stopCondition, maxCharactersPerColumn);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String promptUserInput() {
        System.out.println("N(ext page, P(revious page, F(irst page, L(ast page, eX(it");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private List<Integer> calculateMaxCharactersPerColumn(CSVData csvData, int currentIndex, int stopCondition) {
        List<Integer> maxCharactersPerColumn = new ArrayList(Collections.nCopies(csvData.getHeader().size(), Integer.MIN_VALUE));
        for (int j = 0; j < csvData.getHeader().size(); j++) {
            maxCharactersPerColumn.set(j, Math.max(maxCharactersPerColumn.get(j), csvData.getHeader().get(j).length()));
        }
        for (int i = currentIndex; i < stopCondition; i++) {
            List<String> line = csvData.getContent().get(i);
            for (int j = 0; j < line.size(); j++) {
                maxCharactersPerColumn.set(j, Math.max(maxCharactersPerColumn.get(j), line.get(j).length()));
            }
        }
        return maxCharactersPerColumn;
    }

    private void printLine(List<String> columns, List<Integer> maxCharactersPerColumn) {
        String header = "";
        for (int j = 0; j < columns.size(); j++) {
            String adaptedColumn = columns.get(j);
            while (adaptedColumn.length() < maxCharactersPerColumn.get(j)) {
                adaptedColumn += " ";
            }
            header += adaptedColumn + "|";
        }
        System.out.println(header);
    }

    private void printSeparator(List<Integer> maxCharactersPerColumn) {
        String separator = "";
        for (Integer columnLength : maxCharactersPerColumn) {
            separator += "-".repeat(columnLength) + "+";
        }
        System.out.println(separator);
    }

    private void printContent(HashMap<Integer, List<String>> content,
                              Integer currentIndex, Integer stopCondition,
                              List<Integer> maxCharactersPerColumn) {
        for (int i = currentIndex; i < stopCondition; i++) {
            printLine(content.get(i), maxCharactersPerColumn);
        }
    }


}
