package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Class for control of the AnalyzerReader and AnalyzerWriter classes, doing the readness and convertion for all the files inserted
 * @author Nicolas Canova
 * @version 1.0
 * @since First version of the application
*/

public class AnalyzerController {
    
    private final String[] fileNames;

    /**
     * Constructor method calling a vector of strings with the names of the files that will be processed
     * @param fileNames String[] - Inserted file names
     */
    public AnalyzerController(String[] fileNames) {
        this.fileNames = fileNames;
    }

    /**
     * Method for use the classes AnalyzerReader and AnalyzerWriter,
     * first using the reader for generate the digraph, then the writer for convert it to csv
     */
    public void processFiles() throws IOException {
        for (String fileName : fileNames) {
            try {
            AnalyzerReader reader = new AnalyzerReader(fileName);

            TreeMap<String, ArrayList<String>> digraph = reader.generateDigraph();

            AnalyzerWriter writer = new AnalyzerWriter(fileName, digraph);

            writer.writeToCSV();
            }catch (IOException e) {
                System.err.println("Error processing the file [" + fileName + "]: " + e.getMessage());
            }
        }
    }
}
