import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x, y;

        System.out.println("Insira um inteiro: ");
        x = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Insira outro inteiro: ");
        y = scanner.nextInt();
        scanner.nextLine();

        System.out.println("O maior número é: " + Math.max(x, y));
    }
}
