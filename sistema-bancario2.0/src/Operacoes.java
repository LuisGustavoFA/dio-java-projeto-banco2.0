import java.util.Scanner;

public class Operacoes {
    Scanner sc = new Scanner(System.in);
    Banco b = new Banco();

    public int menu() {
        System.out.println();
        System.out.println("Digite a opção que deseja realizar: ");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Depositar");
        System.out.println("3 - Sacar");
        System.out.println("4 - Transferir");
        System.out.println("5 - Listar contas no banco");
        System.out.println("6 - Finalizar");
        System.out.println();
        int opcao = sc.nextInt();
        return opcao;
    }

    public void criarConta() {
        System.out.println("Digite 1 para conta corrente ou 2 para conta poupança");
        int opcao = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o seu nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite o seu CPF");
        String cpf = sc.nextLine();
        String cnpj = null;
        if (opcao == 2) {
            System.out.println("Digite o CNPJ da sua empresa");
            cnpj = sc.nextLine();
            ContaPoupanca cp = new ContaPoupanca(b, new Cliente(nome, cpf), cnpj);
        } else {
            ContaCorrente cc = new ContaCorrente(b, new Cliente(nome, cpf));
        }
    }

    public void depositar() {
        System.out.println("Digite a agencia da conta para realizar o depósito: ");
        int agencia = sc.nextInt();
        boolean encontrada = false;
        for (ContaBancaria c : b.getContas()) {
            if (c.getAgencia() == agencia) {
                System.out.println("Digite o valor que deseja depositar: ");
                double valor = sc.nextDouble();
                c.depositar(valor);
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("Conta não encontrada.");
        }
    }

    public void sacar() {
        System.out.println("Digite a agencia da conta para realizar o saque: ");
        int agencia = sc.nextInt();
        boolean encontrada = false;
        for (ContaBancaria c : b.getContas()) {
            if (c.getAgencia() == agencia) {
                System.out.println("Digite o valor que deseja sacar: ");
                double valor = sc.nextDouble();
                c.sacar(valor);
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("Conta não encontrada.");
        }
    }

    public void transferir() {
        System.out.println("Digite a agencia da sua conta: ");
        int agencia = sc.nextInt();
        boolean encontrada1 = false;
        boolean encontrada2 = false;

        for (ContaBancaria c1 : b.getContas()) {
            if (c1.getAgencia() == agencia) {
                System.out.println("Digite a agencia da conta para qual deseja realizar a transferencia: ");
                int agencia2 = sc.nextInt();
                for (ContaBancaria c2 : b.getContas()) {
                    if (c2.getAgencia() == agencia2) {
                        System.out.println("Digite o valor a ser transferido: ");
                        double valor = sc.nextDouble();
                        c1.transferir(c2, valor);
                        encontrada2 = true;
                    }
                }
                encontrada1 = true;
            }
        }

        if (!encontrada1 || !encontrada2) {
            System.out.println("Conta não encontrada.");
        }
    }

    public void listarContas() {
        b.listarContas();
    }
}
