package test;

public class Test {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    protected void printTestResult(String className, String testName, boolean isSuccessful) {
        String msg = "Test for " + className + " and method " + testName + " completed with ";
        if (isSuccessful) {
            msg += ANSI_GREEN + "SUCCESS!" + ANSI_RESET;
        } else {
            msg += ANSI_RED + "ERROR!" + ANSI_RESET;
        }
        System.out.println(msg);
    }
}
