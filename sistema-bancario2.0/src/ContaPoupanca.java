public class ContaPoupanca extends ContaBancaria{
    private String cnpj;

    public ContaPoupanca(Banco b, Cliente cliente, String cnpj) {
        super(b, cliente);
        this.cnpj = cnpj;
    }

    @Override
    public void verDetalhes() {
        System.out.println("CNPJ Empresa: " + cnpj);
        System.out.println("Agência: " + agencia);
        System.out.println("Saldo: R$" + saldo);
    }

}