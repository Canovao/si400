package project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class for convert the digraph to csv,
 * containing the necessary methods and the attribute is the name of the file and the generated digraph
 * @author Nicolas Canova
 * @version 1.0
 * @since First version of the code
 */

public class AnalyzerWriter {

    private final String fileName;
    private final TreeMap<String, ArrayList<String>> digraph;

    /**
     * Constructor method of the class,
     * calling the name o the file and the generated digraph
     * @param fileName String - File name
     * @param digraph TreeMap<String, ArrayList<String>> - Generated digraph for AnalyzerReader class
     */
    public AnalyzerWriter(String fileName, TreeMap<String, ArrayList<String>> digraph) {
        this.fileName = fileName;
        this.digraph = digraph;
    }

    /**
     * Method for convert the digraph to csv,
     * writing a message in the console in case of sucess of the process
    */
    public void writeToCSV() throws IOException {
        String outputFileName = fileName.replace(".txt", ".csv");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (Map.Entry<String, ArrayList<String>> entry : digraph.entrySet()) {
                String source = entry.getKey();

                ArrayList<String> destinations = entry.getValue();

                String line = source + ", " + String.join(", ", destinations);

                writer.write(line);
                writer.newLine();
            }
        }

        System.out.println("CSV file sucessfully generated: " + outputFileName);
    }
}
