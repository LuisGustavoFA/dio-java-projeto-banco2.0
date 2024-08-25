public abstract class ContaBancaria{
    private static int SEQUENCIAL = 1102;

    protected int agencia;
    protected double saldo;
    protected Cliente cliente;

    public ContaBancaria(Banco b, Cliente cliente) {
        this.agencia = SEQUENCIAL++;
        this.saldo = 0.0;
        this.cliente = cliente;
        b.adicionarConta(this);
    }

    public int getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito realizado no valor de R$" + valor + ".");
    }

    public void sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque realizado no valor de R$" + valor + ".");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void transferir(ContaBancaria c, double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            c.setSaldo(c.getSaldo() + valor);
            System.out.println("Transferência de R$" + valor + " realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public abstract void verDetalhes();
}
