
public class Ex3 {

	public static void main(String[] args) {

		int [] array = new int[5];
		
		for(int x = 0; x < 5; x++) {
			array[x] = x;
		}
		
		for (int i = 0; i <= 5; i ++) {
			try {
				System.out.println("Número da posição " + i + " :" + array[i]);
			} catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Chegou no limite do array.");
			}
		}
	}
}
