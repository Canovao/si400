package project;

import java.io.*;
import java.util.*;

/**Classe para ler o arquivo passado e gerar o dígrafo, contendo como atributo o nome do arquivo e métodos necessários
* @author Nicolas Canova
* @version 1.0
* @since Primeira versão da aplicação
*/

public class AnalyzerReader {

    private String fileName;

    /**Método construtor da classe, chamando o nome do arquivo 
    * @param fileName String - Nome do arquivo para leitura
    */
    
    public AnalyzerReader(String fileName) {
        this.fileName = fileName;
    }

    /**Método para leitura do arquivo e geração do dígrafo
    * @return Map<String, List<String>> - Dígrafo gerado
    */
    
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
        }

        return digraph;
    }
}
