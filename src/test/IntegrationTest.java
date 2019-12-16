package test;

import com.exxeta.Main;
import com.exxeta.domain.CSVData;
import com.exxeta.ui.UserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class IntegrationTest extends Test {

    public void runTests() {
        /**
        * Set up the list of inputs we want to give
        * */
        List<String> commands = new ArrayList<>(List.of("N", "N", "L", "N", "P", "F", "P", "X"));

        /**
         * Set up the custom ui tester
         * */
        UITester uiTester = new UITester(commands);

        /**
         * Launch the program with the custom ui tester and arguments
         * */
        String[] args = {"besucher.csv", "10"};
        Main.runCSVViewer(uiTester, args);

        /**
         * Verify that the output is as expected
         * */
        List<String> output = uiTester.getOutputs();
        printTestResult("IntegrationTest", "runTests - Output Count Test" ,
                output.size() == 8);

        printTestResult("IntegrationTest", "runTests - 1st Output Test" ,
                output.get(0).equals(uiTester.pageString(10,0)));

        printTestResult("IntegrationTest", "runTests - 2nd Output Test" ,
                output.get(1).equals(uiTester.pageString(10,1)));

        printTestResult("IntegrationTest", "runTests - 3rd Output Test" ,
                output.get(2).equals(uiTester.pageString(10,2)));

        printTestResult("IntegrationTest", "runTests - 4th Output Test" ,
                output.get(3).equals(uiTester.pageString(10,99)));

        printTestResult("IntegrationTest", "runTests - 5th Output Test" ,
                output.get(4).equals(uiTester.pageString(10,99)));

        printTestResult("IntegrationTest", "runTests - 6th Output Test" ,
                output.get(5).equals(uiTester.pageString(10,98)));

        printTestResult("IntegrationTest", "runTests - 7th Output Test" ,
                output.get(6).equals(uiTester.pageString(10,0)));

        printTestResult("IntegrationTest", "runTests - 8th Output Test" ,
                output.get(7).equals(uiTester.pageString(10,0)));
    }

    /**
     * Custom UI Tester that provides the prefined input and stores a list of the outputs
     * */
    private class UITester implements UserInterface {
        List<String> outputs = new ArrayList<>();
        List<String> inputs;
        Integer inputCounter;

        UITester(List<String> inputs) {
            inputCounter = 0;
            this.inputs = inputs;
        }

        @Override
        public void printError(String message) {
            outputs.add(message);
        }

        @Override
        public void printPage(CSVData csvData, int pageSize, int pageNumber) {
            outputs.add(pageString(pageSize,pageNumber));
        }

        public String pageString(int pageSize, int pageNumber) {
            return "pageSize: " + pageSize + " pageNumber: " + pageNumber;
        }

        @Override
        public String promptUserInput() {
            return inputs.get(inputCounter++);
        }

        public List<String> getOutputs() {
            return outputs;
        }
    }
}
