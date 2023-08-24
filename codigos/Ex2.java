import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite um número inteiro:");
		
        String n = scanner.nextLine();

        scanner.close();

        try {
            int numeroInteiro = Integer.parseInt(n);
            System.out.println("Você digitou um número inteiro: " + numeroInteiro);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Certifique-se de digitar um número inteiro.");
        }
	}
}
