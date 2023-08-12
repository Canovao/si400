import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inteiro;
        double flutuanteDuplo;
        float flutuante;
        boolean booleano;
        byte numeroByte;
        short numeroCurto;
        long numeroLongo;
        String texto;

        System.out.println("Insira um inteiro:");
        inteiro = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Insira um double:");
        flutuanteDuplo = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Insira um float:");
        flutuante = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Insira um boolean:");
        booleano = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("Insira um byte:");
        numeroByte = scanner.nextByte();
        scanner.nextLine();

        System.out.println("Insira um short:");
        numeroCurto = scanner.nextShort();
        scanner.nextLine();

        System.out.println("Insira um long:");
        numeroLongo = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Insira uma String:");
        texto = scanner.next();
        scanner.nextLine();

        System.out.println("Inteiro inserido: " + inteiro);
        System.out.println("Double inserido: " + flutuanteDuplo);
        System.out.println("Float inserido: " + flutuante);
        System.out.println("Boolean inserido: " + booleano);
        System.out.println("Byte inserido: " + numeroByte);
        System.out.println("Short inserido: " + numeroCurto);
        System.out.println("Long inserido: " + numeroLongo);
        System.out.println("String inserido: " + texto);
    }
}
