import java.io.*;
import java.util.*;

/**
 * Classe principal que inicia o programa.
 */
public class AnalyzerStart {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java AnalyzerStart <arquivo1.txt> <arquivo2.txt> ...");
            return;
        }

        try {
            AnalyzerController controller = new AnalyzerController(args);
            controller.processFiles();
        } catch (IOException e) {
            System.err.println("Erro ao processar os arquivos: " + e.getMessage());
        }
    }
}

/**
 * Classe que controla a execução do programa.
 */
class AnalyzerController {
    private String[] fileNames;

    public AnalyzerController(String[] fileNames) {
        this.fileNames = fileNames;
    }

    public void processFiles() throws IOException {
        for (String fileName : fileNames) {
            AnalyzerReader reader = new AnalyzerReader(fileName);
            Map<String, List<String>> digraph = reader.generateDigraph();
            AnalyzerWriter writer = new AnalyzerWriter(fileName, digraph);
            writer.writeToCSV();
        }
    }
}

/**
 * Classe responsável por ler e tokenizar o arquivo de entrada.
 */
class AnalyzerReader {
    private String fileName;

    public AnalyzerReader(String fileName) {
        this.fileName = fileName;
    }

    public Map<String, List<String>> generateDigraph() throws IOException {
        Map<String, List<String>> digraph = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase().replaceAll("[^a-z ]", ""); // Converte para minúsculas e remove pontuações
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
        }

        return digraph;
    }
}

/**
 * Classe responsável por escrever o dígrafo em formato CSV.
 */
class AnalyzerWriter {
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
        System.out.println("Arquivo CSV gerado com sucesso: " + outputFileName);
    }
}
