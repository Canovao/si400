package project;

import java.io.*;
import java.util.*;

public class AnalyzerReader {

    private String fileName;

    public AnalyzerReader(String fileName) {
        this.fileName = fileName;
    }

    public Map<String, List<String>> generateDigraph() throws IOException {
        Map<String, List<String>> digraph = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase().replaceAll("[^a-z ]", "");
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
            System.err.println("Erro ao ler o arquivo " + fileName + ": " + e.getMessage());
        }
        return digraph;
    }
}