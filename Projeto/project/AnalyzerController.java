package project;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnalyzerController {
    
    private String[] fileNames;

    public AnalyzerController(String[] fileNames) {
        this.fileNames = fileNames;
    }

    public void processFiles() throws IOException {
        for (String fileName : fileNames) {
                try {
                AnalyzerReader reader = new AnalyzerReader(fileName);

                Map<String, List<String>> digraph = reader.generateDigraph();

                AnalyzerWriter writer = new AnalyzerWriter(fileName, digraph);

                writer.writeToCSV();
                }catch (IOException e) {
                    System.err.println("Erro ao processar o arquivo " + fileName + ": " + e.getMessage());
                }
    
        }
    }
}