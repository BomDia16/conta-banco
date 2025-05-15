public class Clientes {

    // Informações do cliente
    private int numero;
    private String agencia;
    private String nome;
    private Saldo saldo = new Saldo();

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
        return saldo.getSaldo();
    }

    public void setSaldo(double saldo) {
        this.saldo.setSaldo(saldo);
    }

    // Inserir novos clientes
    @SuppressWarnings("OverridableMethodCallInConstructor")
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
        
        return numero + ". " + nome + " | Agência: " + agencia + " | Saldo: R$ " + this.saldo.getSaldo();
    }
}
