public class Main {
    public static void main(String[] args) {
        boolean finalizado = false;
        Operacoes op = new Operacoes();

        while (!finalizado) {
            switch (op.menu()) {
                case 1: {
                    op.criarConta();
                    break;
                }
                case 2: {
                    op.depositar();
                    break;
                }
                case 3: {
                    op.sacar();
                    break;
                }
                case 4: {
                    op.transferir();
                    break;
                }
                case 5: {
                    op.listarContas();
                    break;
                }
                case 6: {
                    finalizado = true;
                    System.out.println("Encerrado.");
                    break;
                }
                default: {
                    System.out.println("Opção inválida.");
                }
            }
        }
    }
}
