package com.exxeta;

import com.exxeta.domain.*;
import com.exxeta.exception.EmptyFileException;
import com.exxeta.exception.FileNameMissingException;
import com.exxeta.ui.UserInterface;
import com.exxeta.ui.UserInterfaceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterfaceImpl();
        runCSVViewer(ui, args);
    }

    public static void runCSVViewer(UserInterface userInterface, String[] args) {
        try {

            CSVSettings csvSettings = ArgumentReader.getCSVSettings(args);
            List<String> csvContent = CSVFileReader.readFile(csvSettings.getFileName());
            CSVData csvData = CSVConverter.convert(csvContent);
            paginate(userInterface, csvData, csvSettings);

        } catch (FileNameMissingException | EmptyFileException ex) {
            userInterface.printError(ex.getMessage());
        }
    }

    public static void paginate(UserInterface userInterface, CSVData csvData, CSVSettings csvSettings) {
        boolean running = true;
        int maxPage = csvData.getContent().size() / csvSettings.getPageSize();
        if (csvData.getContent().size() % csvSettings.getPageSize() == 0) {
            maxPage--;
        }
        int currentPage = 0;
        while(running) {
            userInterface.printPage(csvData, csvSettings.getPageSize(), currentPage);
            String input = userInterface.promptUserInput();
            switch (input) {
                case "N":
                    if (currentPage < maxPage) {
                        currentPage++;
                    }
                    break;
                case "P":
                    if (currentPage > 0) {
                        currentPage--;
                    }
                    break;
                case "F":
                    currentPage = 0;
                    break;
                case "L":
                    currentPage = maxPage;
                    break;
                case "X":
                    running = false;
                    break;
            }

        }
    }
}
