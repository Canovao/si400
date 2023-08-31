
public class Ex6
 {

	public static void main(String[] args) {
		try {
			System.out.println("Esse try não possui nenhum erro");
		}catch(Exception e) {
			System.out.println("Erro:"+e.getMessage());
		}finally {
			System.out.println("O finally será sempre será executado");
		}
		try {
			int i = 5/0;
			System.out.print(i);
		}catch(ArithmeticException e) {
			System.out.println("Erro:"+e.getMessage());
		}finally {
			System.out.print("Esse outro bloco try-catch-finally apresentou um erro e mesmo assim o finally é executado");;
		}

	}

}
