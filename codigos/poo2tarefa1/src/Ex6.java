import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int MAX_SIZE = 5;

        String[] strings = new String[MAX_SIZE];

        int buffer = -1;

        do{
            buffer++;
            System.out.println("Insira um texto no array de Strings: ");
            strings[buffer] = scanner.nextLine();
        }while(!strings[buffer].endsWith("FIM") && buffer != MAX_SIZE - 1);

        while(buffer != -1){
            System.out.println("Texto inserido na posição [" + buffer + "]: " + strings[buffer]);
            buffer--;
        }
    }
}
