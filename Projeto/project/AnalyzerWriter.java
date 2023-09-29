package project;

import java.io.*;
import java.util.*;

/**Classe para converter o dígrafo passado para csv, contendo os métodos necessários e como atributos o nome do arquivo e dígrafo gerado
* @author Nicolas Canova
* @version 1.0
* @since Primeira versão da aplicação
*/

public class AnalyzerWriter {

    private String fileName;
    private Map<String, List<String>> digraph;

    public AnalyzerWriter(String fileName, Map<String, List<String>> digraph) {
        this.fileName = fileName;
        this.digraph = digraph;
    }

    public void writeToCSV() throws IOException {
        String outputFileName = fileName.replace(".txt", ".csv");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (Map.Entry<String, List<String>> entry : digraph.entrySet()) {
                String source = entry.getKey();

                List<String> destinations = entry.getValue();

                StringBuilder line = new StringBuilder(source);

                line.append(", ");
                line.append(String.join(", ", destinations));

                writer.write(line.toString());
                writer.newLine();
            }
        }

        System.out.println("CSV file sucessfully generated: " + outputFileName);
    }
}
