public class Clientes {

    // Informações do cliente
    private int numero;
    private String agencia;
    private String nome;
    @SuppressWarnings("FieldMayBeFinal")
    private Saldo saldo = new Saldo();
    private double chequeEspecial;

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo.getSaldo();
    }

    public void setSaldo(double saldo) {
        this.saldo.setSaldo(saldo);
        SetChequeSaldo(saldo);
    }

    public double GetChequeEspecial(int numeroCliente) {
        return chequeEspecial;
    }

    public void SetChequeSaldo(double saldo) {
        if (saldo <= 500) {
            this.chequeEspecial = 50;
        } else {
            this.chequeEspecial = saldo * 0.5;
        }
    }

    public Clientes() {

    }

    // Inserir novos clientes
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Clientes(int numero, String agencia, String nome, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nome = nome;
        setSaldo(saldo);
    }

    // Mensagem de listagem de clientes
    public String Mensagem() {
        numero = this.numero;
        nome = this.nome;
        agencia = this.agencia;
        chequeEspecial = this.chequeEspecial;
        
        return numero + ". " + nome + " | Agência: " + agencia + " | Saldo: R$ " + this.saldo.getSaldo() + " | Cheque Especial: R$ " + chequeEspecial;
    }
}
