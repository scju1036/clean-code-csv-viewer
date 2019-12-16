package test;

import com.exxeta.domain.ArgumentReader;
import com.exxeta.domain.CSVSettings;
import com.exxeta.exception.FileNameMissingException;

class ArgumentReaderTest extends Test{

    public void runTests(){
        testWithOneArguments();
        testWithTwoArguments();
    }

    private void testWithOneArguments(){
        String[] arguments = {"besucher.csv"};
        boolean success = true;
        try {
            CSVSettings csvSettings = ArgumentReader.getCSVSettings(arguments);
            success = success && csvSettings.getFileName().equals(arguments[0]);
            success = success && csvSettings.getPageSize() == ArgumentReader.DEFAULT_PAGE_SIZE;

        } catch (FileNameMissingException e) {
            e.printStackTrace();
            success = false;
        }

        super.printTestResult(
                "ArgumentReaderTest",
                "testWithOneArguments",
                success
        );
    }

    private void testWithTwoArguments(){
        String[] arguments = {"besucher.csv","20"};
        boolean success = true;
        try {
            CSVSettings csvSettings = ArgumentReader.getCSVSettings(arguments);
            success = success && csvSettings.getFileName().equals(arguments[0]);
            success = success && csvSettings.getPageSize() == 20;

        } catch (FileNameMissingException e) {
            e.printStackTrace();
            success = false;
        }

        super.printTestResult(
                "ArgumentReaderTest",
                "testWithTwoArguments",
                success
        );
    }
}
