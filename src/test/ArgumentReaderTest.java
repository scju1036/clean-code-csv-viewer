package test;

import com.exxeta.domain.ArgumentReader;
import com.exxeta.domain.CSVSettings;
import com.exxeta.exception.FileNameMissingException;

class ArgumentReaderTest extends Test {

    public void runTests() {
        testWithOneArguments();
        testWithTwoArguments();
    }

    private void testWithOneArguments() {
        // prepare mock data
        String[] arguments = {"besucher.csv"};
        boolean success = true;
        try {
            // execute test
            CSVSettings csvSettings = ArgumentReader.getCSVSettings(arguments);

            // verify results
            success = success && csvSettings.getFileName().equals(arguments[0]);
            success = success && csvSettings.getPageSize() == ArgumentReader.DEFAULT_PAGE_SIZE;

        } catch (FileNameMissingException ex) {
            ex.printStackTrace();
            success = false;
        }

        super.printTestResult(
                ArgumentReaderTest.class.getName(),
                "testWithOneArguments",
                success
        );
    }

    private void testWithTwoArguments() {
        // prepare mock data
        String[] arguments = {"besucher.csv","20"};
        boolean success = true;
        try {
            // execute test
            CSVSettings csvSettings = ArgumentReader.getCSVSettings(arguments);

            // verify results
            success = success && csvSettings.getFileName().equals(arguments[0]);
            success = success && csvSettings.getPageSize() == 20;

        } catch (FileNameMissingException ex) {
            ex.printStackTrace();
            success = false;
        }

        super.printTestResult(
                ArgumentReaderTest.class.getName(),
                "testWithTwoArguments",
                success
        );
    }
}
