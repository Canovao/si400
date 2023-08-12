import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numeroEscolhido;

        System.out.println("Insira um número inteiro: ");
        numeroEscolhido = scanner.nextInt();
        scanner.nextLine();

        for(int i=1; i < 11; i++){
            System.out.println(i + " x " + numeroEscolhido + " = " + i*numeroEscolhido);
        }
    }
}
