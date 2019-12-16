package test;

import com.exxeta.domain.CSVData;
import com.exxeta.ui.UserInterfaceImpl;

import java.util.List;

public class UserInterfaceImplTests extends Test {

    public void runTests() {
        testCalculateMaxCharactersPerColumn();

    }

    public void testCalculateMaxCharactersPerColumn() {
        // prepare mock data
        CSVData csvData = new CSVData();
        csvData.setHeader(List.of("Name", "Vorname", "Strasse", "Ort", "Alter"));
        csvData.getContent().put(1, List.of("Yangda", "Paloma", "P.O. Box 451, 8598 Donec Road", "Bell", "88"));
        csvData.getContent().put(2, List.of("Diaz", "Jayme", "Ap #486-1122 Vestibulum Road", "Lafayette", "45"));
        int currentIndex = 1;
        int stopCondition = 2;
        boolean success = true;

        // execute test
        List<Integer> maxCharactersPerColumn = UserInterfaceImpl.calculateMaxCharactersPerColumn(csvData, currentIndex, stopCondition);

        // verify results
        success = success && maxCharactersPerColumn.size() == 5;
        success = success && maxCharactersPerColumn.equals(List.of(6, 7, 29, 4, 5));

        super.printTestResult(
                UserInterfaceImplTests.class.getName(),
                "testCalculateMaxCharactersPerColumn",
                success
        );

    }
}
