class ExemploA {
    public void metodoComExcecao() throws ArrayIndexOutOfBoundsException {
        int[] array = new int[3];
        int valor = array[5]; 
    }
}

public class Ex9 {
    public void chamarMetodoComExcecao() {
        ExemploA exemplo = new ExemploA();
        try {
            exemplo.metodoComExcecao();
            System.out.println("Método chamado com exceção.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exceção capturada no método de chamada: ");
        }
    }

    public static void main(String[] args) {
        Ex9 exemploB = new Ex9();
        exemploB.chamarMetodoComExcecao();
    }
}
