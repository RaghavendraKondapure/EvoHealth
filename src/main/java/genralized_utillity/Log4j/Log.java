package genralized_utillity.Log4j;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


/*
---> This is Base class to define log4j2 logging mechanism. We can call functions of this class to capture logs on console as well as on file
 */
public class Log {

    // Initialize Log4j logs
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    private static final Logger err = LogManager.getLogger(Log.class);


    // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
    // params : sTestCaseName - test case name
    public static void startTestCase(String sTestCaseName) {

        System.out.print("\n");

        err.info(ANSI_GREEN + "**********************************       STARTED      **********************************" + ANSI_RESET);

        err.info("****************************************************************************************");

        err.info(ANSI_RED + ">>>>>>>>>>>>>>>>>>>>>>>>>>>          " + sTestCaseName + " " + ANSI_RESET);


        err.info("****************************************************************************************\n");

    }

    //This is to print log for the ending of the test case

    public static void endTestCase() {

        err.info(ANSI_GREEN + "**************************             " + "-E---N---D-" + "             *************************\n\n" + ANSI_RESET);


    }

    // Need to create these methods, so that they can be called

    public static void info(String message) {

        err.info(message + "\n");

    }

    public static void warn(String message) {

        err.warn(message + "\n");

    }

    public static void debug(String message) {

        err.debug(message + "\n");

    }

    public static void fatal(String message) {

        err.fatal(message + "\n");

    }

    public static void error(String message) {

        err.error(message + "\n");

    }


}
