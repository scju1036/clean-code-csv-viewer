package test;

public class TestMain {

    public static void main(String[] args) {
        ArgumentReaderTest argumentReaderTest = new ArgumentReaderTest();
        argumentReaderTest.runTests();

        CSVFileReaderTest csvFileReaderTest = new CSVFileReaderTest();
        csvFileReaderTest.runTests();

        CSVConverterTests csvConverterTests = new CSVConverterTests();
        csvConverterTests.runTests();

        UserInterfaceImplTests userInterfaceImplTests = new UserInterfaceImplTests();
        userInterfaceImplTests.runTests();

        IntegrationTest integrationTest = new IntegrationTest();
        integrationTest.runTests();
    }
}
