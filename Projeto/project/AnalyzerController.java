package project;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**Classe para controle das classes AnalyzerReader e AnalyzerWriter, fazendo a leitura e conversão em todos os arquivos passados
 * Class for control of the AnalyzerReader and AnalyzerWriter classes, doing the readness and convertion for all the files inserted
* @author Nicolas Canova
* @version 1.0
* @since Primeira versão da aplicação
* 		 First version of the application
*/

public class AnalyzerController {
    
    private String[] fileNames;

    /**Método construtor chamando um vetor de strings com os nomes dos arquivos que serão processados
     * Constructor method calling a vector of strings with the names of the files that will be processed
    * @param fileNames String[] - Nomes dos arquivos passados
    *                             Names of the inserted files
    */
    
    public AnalyzerController(String[] fileNames) {
        this.fileNames = fileNames;
    }

    /**Método para utilizar as classes AnalyzerReader e AnalyzerWriter, primeiro utilizando o reader para gerar o dígrafo e depois o writer para converte-lo para csv
     * Method for use the classes AnalyzerReader and AnalyzerWriter, first using the reader for generate the digraph, then the writer for convert it to csv
    */
    
    public void processFiles() throws IOException {
        for (String fileName : fileNames) {
            AnalyzerReader reader = new AnalyzerReader(fileName);

            Map<String, List<String>> digraph = reader.generateDigraph();

            AnalyzerWriter writer = new AnalyzerWriter(fileName, digraph);

            writer.writeToCSV();
        }
    }
}
