package project;

import java.io.*;

/**Classe que inicia a aplicação
* @author Nicolas Canova
* @version 1.0
* @since Primeira versão da aplicação
*/

public class AnalyzerStart {

    /**Método principal da aplicação, ele guia o usuário para utilização da aplicação, utiliza o controller para processamento dos arquivos e indica uma mensagem no console no caso de erro
    */
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Use like this: java AnalyzerStart <file1.txt> <file2.txt> ...");

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
