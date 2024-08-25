public class ContaCorrente extends ContaBancaria{

    public ContaCorrente(Banco b, Cliente cliente) {
        super(b, cliente);
    }

    @Override
    public void verDetalhes() {
        System.out.println("CPF Proprietário: " + cliente.getCpf());
        System.out.println("Agência: " + agencia);
        System.out.println("Saldo: R$" + saldo);
    }

}