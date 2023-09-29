package project;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**Classe para controle das classes AnalyzerReader e AnalyzerWriter, fazendo a leitura e conversão em todos os arquivos passados
* @author Nicolas Canova
* @version 1.0
* @since Primeira versão da aplicação
*/

public class AnalyzerController {
    
    private String[] fileNames;

    /**Classe construtora chamando um vetor de strings com os nomes dos arquivos que serão processados
    * @param fileNames String[] - 
    */
    
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
