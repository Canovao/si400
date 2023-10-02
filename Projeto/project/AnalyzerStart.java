package project;

import java.io.*;

/**Classe que inicia a aplicação
 * Class that starts the application
* @author Nicolas Canova
* @version 1.0
* @since Primeira versão da aplicação
*        First version of the application
*/

public class AnalyzerStart {

    /**Método principal da aplicação, ele guia o usuário para utilização da aplicação, utiliza o controller para processamento dos arquivos e indica uma mensagem no console no caso de erro
     * Main method of the application, guides the users to the use of the application, uses the controller for process the files and point to a message in the console in case of error
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
