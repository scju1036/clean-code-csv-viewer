package test;

public class TestMain {

    public static void main(String[] args) {
        ArgumentReaderTest argumentReaderTest = new ArgumentReaderTest();
        argumentReaderTest.runTests();

        CSVFileReaderTest csvFileReaderTest = new CSVFileReaderTest();
        csvFileReaderTest.runTests();
    }
}
