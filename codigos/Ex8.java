public class Ex8
 {
	public static void main(String[] args) {
		try {
			int r = dividirPorZero();
		} catch (RuntimeException e) {
			
			System.out.println("RuntimeException!");
			
		}
	}
	
	public static int dividirPorZero() {
		try {
			return 10/0;
		} catch(ArithmeticException e) {
			
			System.out.println("Excessão Aritmética!");
			throw new RuntimeException("RuntimeException occurred", e);
			
		}
	}
}

