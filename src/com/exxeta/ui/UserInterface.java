package com.exxeta.ui;

import com.exxeta.domain.CSVData;

public interface UserInterface {

    public void printError(String message);

    public void printPage(CSVData csvData, int pageSize, int pageNumber);

    public String promptUserInput();
}
