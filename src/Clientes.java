public class Clientes {

    // Informações do cliente
    private int numero;
    private String agencia;
    private String nome;
    private double saldo;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Inserir novos clientes
    public Clientes(int numero, String agencia, String nome, double saldo) {
        setNumero(numero);
        setAgencia(agencia);
        setNome(nome);
        setSaldo(saldo);
    }

    // Mensagem de listagem de clientes
    public String Mensagem() {
        numero = getNumero();
        nome = getNome();
        agencia = getAgencia();
        saldo = getSaldo();
        
        return numero + ". " + nome + " | Agência: " + agencia + " | Saldo: R$ " + saldo;
    }
}
