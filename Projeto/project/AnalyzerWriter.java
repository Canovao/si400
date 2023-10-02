package project;

import java.io.*;
import java.util.*;

/**Classe para converter o dígrafo passado para csv, contendo os métodos necessários e como atributos o nome do arquivo e dígrafo gerado
 * Class for convert the digraph to csv, containing the necessary methods and the attribute is the name of the file and the generated digraph
* @author Nicolas Canova
* @version 1.0
* @since Primeira versão da aplicação
*        First version of the code
*/

public class AnalyzerWriter {

    private String fileName;
    private Map<String, List<String>> digraph;

    /**Método construtor da classe, chamando o nome do arquivo e dígrafo gerado
     * Constructor method of the class, calling the name o the file and the generated digraph
    * @param fileName String - Nome do arquivo
    *                          File name
    * @param digraph Map<String, List<String>> - Dígrafo gerado pela classe AnalyzerReader
    *                                            Generated digraph for AnalyzerReader class      
    */
    
    public AnalyzerWriter(String fileName, Map<String, List<String>> digraph) {
        this.fileName = fileName;
        this.digraph = digraph;
    }

    /**Método para converter o dígrafo para csv, escrevendo uma mensagem no console no caso de sucesso do processo
     * Method for convert the digraph to csv, writing a message in the console in case of sucess of the process
    */
    
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
