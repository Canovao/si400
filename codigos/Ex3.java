public class ContaBancaria {
    private double saldo;
    private String numeroDaConta;

    public ContaBancaria(String numeroDaConta, double saldoInicial) {
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de " + valor + " realizado. Novo saldo: " + saldo);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado. Novo saldo: " + saldo);
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido.");
        }
    }

    public double verificarSaldo() {
        return saldo;
    }

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("12345", 1000.0);

        System.out.println("Saldo inicial: " + conta.verificarSaldo());

        conta.depositar(500.0);
        conta.sacar(200.0);
        conta.sacar(1500.0);

        System.out.println("Saldo final: " + conta.verificarSaldo());
    }
}
