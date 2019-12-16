package com.exxeta.exception;

public class EmptyFileException extends Exception {
    public EmptyFileException() {
        super("The provided file is empty or missing");
    }
}
