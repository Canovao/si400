import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x, y;

        System.out.println("Insira um inteiro: ");
        x = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Insira outro inteiro: ");
        y = scanner.nextInt();
        scanner.nextLine();

        // Refaça o exercício anterior utilizando: a) estrutura condicional if-else; b) operador condicionala ternário.

        if(x > y){
            System.out.println("O primeiro número é maior que o segundo: " + x);
        }else{
            System.out.println("O segundo número é maior que o primeiro: " + y);
        }

        System.out.println((x > y) ? "O primeiro número é maior que o segundo: " + x : "O segundo número é maior que o primeiro: " + y);
    }
}
