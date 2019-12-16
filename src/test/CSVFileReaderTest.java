package test;

import com.exxeta.domain.CSVFileReader;

import java.util.List;

class CSVFileReaderTest extends Test{

    public void runTests(){
        testReadFile("besucher.csv");
        testReadFile("personen.csv");
    }

    private void testReadFile(String filename){
        List<String> file = CSVFileReader.readFile(filename);
        printTestResult(
                "CSVFileReaderTest",
                "testReadFile - " + filename,
                !file.isEmpty()
                );
    }
}