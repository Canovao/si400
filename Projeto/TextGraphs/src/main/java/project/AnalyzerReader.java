package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

/**C
 * Class to read the file inserted and generate the digraph,
 * containing the needed methods and the name of the files like an attribute
 * @author Nicolas Canova
 * @version 1.0
 * @since First version of the application
 */

public class AnalyzerReader {

    private final String fileName;

    /**
     * Constructor method of the class, calling the name of the file
     * @param fileName String - File name to read
     */
    public AnalyzerReader(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Method for readless of the file and generation of the digraph
     * @return TreeMap<String, ArrayList<String>> - Tree map of generated digraph to be written into .csv file
     */
    public TreeMap<String, ArrayList<String>> generateDigraph() throws IOException {
        TreeMap<String, ArrayList<String>> digraph = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim().toLowerCase().replaceAll(",", "");
                String[] words = line.split("\\s+");

                for (int i = 0; i < words.length - 1; i++) {
                    String source = words[i];
                    String destination = words[i + 1];

                    digraph.putIfAbsent(source, new ArrayList<>());
                    
                    if (!digraph.get(source).contains(destination)) {
                        digraph.get(source).add(destination);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file [" + fileName + "]: " + e.getMessage());
            throw new IOException(e.getMessage());
        }

        return digraph;
    }
}
