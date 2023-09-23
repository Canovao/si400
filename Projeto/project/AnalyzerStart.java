package project;

import java.io.*;

public class AnalyzerStart {

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
