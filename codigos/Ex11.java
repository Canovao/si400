import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.LogRecord;
import java.util.logging.Level;

public class Ex11 {
    private static final Logger LOGGER = Logger.getLogger("InfoLogging");

    public static void main(String[] args) {
        String conteudo = "Exercicio 10 2";
        LOGGER.log(new LogRecord(Level.INFO, "Conteúdo a ser guardado: " + conteudo));

        String caminhoDoArquivo = "./teste.txt";
        LOGGER.log(new LogRecord(Level.INFO, "Arquivo que guardará o conteúdo: " + caminhoDoArquivo));

        try (FileWriter escritor = new FileWriter(caminhoDoArquivo)) {
            escritor.write(conteudo);
            LOGGER.log(new LogRecord(Level.INFO, "O conteúdo foi salvo perfeitamente."));
        } catch (IOException e) {
            LOGGER.log(new LogRecord(Level.INFO, "Aconteceu um erro ao salvar no arquivo, verifique o caminho do arquivo " + e.getMessage()));
        }
    }
}
