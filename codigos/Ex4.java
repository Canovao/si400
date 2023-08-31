import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Ex4 {

	public static void main(String[] args) {
		try {
			Scanner p = new Scanner(System.in);
			System.out.print("Insira o caminho do arquivo:");
			String path = p.nextLine();
			p.close();
			String linha = "";
			BufferedReader leitor = new BufferedReader(new FileReader(path));
			while(true) {
				if(linha!= null) {
					System.out.println(linha);
				}else {
					leitor.close();
					break;
				}
				linha = leitor.readLine();
			}
		}catch (IOException err){
			System.out.println("Erro: "+err.getMessage()+"\n"+err.getCause());
		}

	}

}
