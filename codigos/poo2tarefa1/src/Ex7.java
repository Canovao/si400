import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int escolha;

        System.out.println("""
                (1, salada)
                (2, arroz e feijão)
                (3, espaguete ao sugo)
                (4, misto quente)
                (5, misto frio)
                (6, arroz e ovo frito)""");

        System.out.println("Insira a sua preferência de comida para o próximo almoço: ");
        escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1 -> System.out.println("Prato selecionado: Salada");
            case 2 -> System.out.println("Prato selecionado: Arroz e feijão");
            case 3 -> System.out.println("Prato selecionado: Espaguete ao sugo");
            case 4 -> System.out.println("Prato selecionado: Misto quente");
            case 5 -> System.out.println("Prato selecionado: Misto frio");
            case 6 -> System.out.println("Prato selecionado: Arroz e ovo frito");
            default -> System.out.println("Prato selecionado indisponível!");
        }
    }
}
