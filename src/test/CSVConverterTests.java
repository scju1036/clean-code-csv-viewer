package test;

import com.exxeta.domain.CSVConverter;
import com.exxeta.domain.CSVData;
import com.exxeta.exception.EmptyFileException;

import java.util.List;

public class CSVConverterTests extends Test {

    public void runTests() {
        testConvert();
        testConvertEmptyMock();
    }

    private void testConvert() {
        // prepare mock data
        List<String> mockContent = List.of(
            "Name;Vorname;Strasse;Ort;Alter",
            "Yang;Paloma;P.O. Box 451, 8598 Donec Road;Bell;88",
            "Diaz;Jayme;Ap #486-1122 Vestibulum Road;Lafayette;45"
        );
        boolean success = true;

        try {
            // execute test
            CSVData csvData = CSVConverter.convert(mockContent);

            // verify results
            success = success && csvData.getHeader().size() == 5;
            success = success && csvData.getHeader().equals(List.of("Name", "Vorname", "Strasse", "Ort", "Alter"));
            success = success && csvData.getContent().size() == 2;
            success = success && csvData.getContent().get(1).equals(List.of("Yang", "Paloma", "P.O. Box 451, 8598 Donec Road", "Bell", "88"));

        } catch (EmptyFileException ex) {
            ex.printStackTrace();
            success = false;
        }

        super.printTestResult(
                CSVConverterTests.class.getName(),
                "testConvert",
                success
        );

    }

    private void testConvertEmptyMock() {
        // prepare mock data
        List<String> mockContent = List.of();
        boolean success = false;

        try {
            // execute test
            CSVData csvData = CSVConverter.convert(mockContent);
        } catch (EmptyFileException ex) {
            // verify results
            success = true;
        }

        super.printTestResult(
                CSVConverterTests.class.getName(),
                "testConvertEmptyMock",
                success
        );
    }
}
