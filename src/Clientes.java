public class Clientes {

    // Informações do cliente
    private int numero;
    private String agencia;
    private String nome;
    private double saldo;

    // Inserir novos clientes
    public Clientes(int numero, String agencia, String nome, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nome = nome;
        this.saldo = saldo;
    }

    // Mensagem de listagem de clientes
    public String Mensagem() {
        return numero + ". " + nome + " | Agência: " + agencia + " | Saldo: R$ " + saldo;
    }
}
