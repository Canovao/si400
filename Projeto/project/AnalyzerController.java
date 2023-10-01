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

    /**Método construtor chamando um vetor de strings com os nomes dos arquivos que serão processados
    * @param fileNames String[] - Nomes dos arquivos passados
    */
    
    public AnalyzerController(String[] fileNames) {
        this.fileNames = fileNames;
    }

    /**Método para utilizar as classes AnalyzerReader e AnalyzerWriter, primeiro utilizando o reader para gerar o dígrafo e depois o writer para converte-lo para csv
    */
    
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