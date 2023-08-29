public class Pessoa {
    private String nome;
    private int idade;

    public void setNome(String novoNome) {
        nome = novoNome;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(int novaIdade) {
        idade = novaIdade;
    }

    public int getIdade() {
        return idade;
    }

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("João", 25);
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());

        pessoa.setNome("Maria");
        pessoa.setIdade(30);
        System.out.println("Novo nome: " + pessoa.getNome());
        System.out.println("Nova idade: " + pessoa.getIdade());
    }
}
