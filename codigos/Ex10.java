import java.io.FileWriter;
import java.io.IOException;

public class Ex10 {
    public static void main(String[] args) {
        String conteudo = "Exercicio 10 2";

        String caminhoDoArquivo = "./teste.txt";
        try (FileWriter escritor = new FileWriter(caminhoDoArquivo)) {
            escritor.write(conteudo);
            System.out.println("O conteúdo foi salvo perfeitamente.");
        } catch (IOException e) {
            System.out.println("Aconteceu um erro ao salvar no arquivo, verifique o caminho do arquivo " + e.getMessage());
        }
    }
}
