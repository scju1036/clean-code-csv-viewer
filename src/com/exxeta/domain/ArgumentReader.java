package com.exxeta.domain;

import com.exxeta.exception.FileNameMissingException;

public class ArgumentReader {

    public static int DEFAULT_PAGE_SIZE = 3;

    public static CSVSettings getCSVSettings(String[] arguments) throws FileNameMissingException {
        if (arguments != null && arguments.length > 0) {
            CSVSettings csvSettings = new CSVSettings();
            csvSettings.setFileName(arguments[0]);
            if (arguments.length > 1) {
                csvSettings.setPageSize(Integer.parseInt(arguments[1]));
            } else {
                csvSettings.setPageSize(DEFAULT_PAGE_SIZE);
            }
            return csvSettings;

        }
        throw new FileNameMissingException();
    }
}
