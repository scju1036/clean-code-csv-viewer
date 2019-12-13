package com.exxeta.exception;

public class FileNameMissingException extends Exception {

    public FileNameMissingException() {
        super("Missing file name!");
    }
}
