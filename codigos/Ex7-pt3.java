import meupacote.ClassePrivada;

public class AcessoExterno {
    public static void main(String[] args) {
        ClassePrivada privada = new ClassePrivada(); // Isso resultará em erro de compilação
        privada.metodoPrivado(); // Isso resultará em erro de compilação
    }
}
