package project;

import java.io.*;
import java.util.*;

/**Classe para ler o arquivo passado e gerar o dígrafo, contendo os métodos necessários e como atributo o nome do arquivo
 * Class to read the file inserted and generate the digraph, containing the needed methods and the name of the files like an attribute
* @author Nicolas Canova
* @version 1.0
* @since Primeira versão da aplicação
*        Firs version of the application
*/

public class AnalyzerReader {

    private String fileName;

    /**Método construtor da classe, chamando o nome do arquivo
     * Constructor method of the class, calling the name of the file 
    * @param fileName String - Nome do arquivo para leitura
    *                          Name of the file for readness
    */
    
    public AnalyzerReader(String fileName) {
        this.fileName = fileName;
    }

    /**Método para leitura do arquivo e geração do dígrafo
     * Method for readless of the file and generation of the digraph
    * @return Map<String, List<String>> - Dígrafo gerado
    *                                     Digraph generated
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
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + fileName + ": " + e.getMessage());
        }
        return digraph;
    }
}
