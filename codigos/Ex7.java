import java.util.Scanner;

public class Ex7 {
	public static void main(String[] args) {
		int[] num = { 15, 25, 35, 45};
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Digite o indice do vetor:");
		int index = s.nextInt();
		
		System.out.println("Digite o número para divisão:");
		int div= s.nextInt();
		
		try {
			
			int res = num[index-1]/div;
			System.out.println("Resultado:" + res);
			
		} catch(ArithmeticException e){
			
			System.out.println("Impossível realizar a divisão!");
			
		} catch(ArrayIndexOutOfBoundsException e){
			
			System.out.println("Impossível acessar o índice!");
		}
		

	}
}
