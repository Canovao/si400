import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o dividendo:");
		double n1 = scanner.nextDouble();
		
		System.out.println("dividido por...:");
		double n2 = scanner.nextDouble();

		scanner.close();
		
		try {
			double div = n1/n2;
            System.out.println("Resultado: " + div);
        } catch (ArithmeticException e) {
            System.out.println("Erro de divisão por zero!");
		}
	}
}
