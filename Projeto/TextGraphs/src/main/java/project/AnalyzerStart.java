package project;

import java.io.IOException;

/**
 * Class that starts the application
 * @author Nicolas Canova
 * @version 1.0
 * @since First version of the application
 */

public class AnalyzerStart {

    /**
     * Main method of the application, guides the users to the use of the application,
     * uses the controller for process the files and point to a message in the console in case of error
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Send program arguments like this: java AnalyzerStart <file1.txt> <file2.txt> ...");

            return;
        }

        try {
            AnalyzerController controller = new AnalyzerController(args);

            controller.processFiles();
        } catch (IOException e) {
            System.err.println("Error at processing the files: " + e.getMessage());
        }
    }
}
