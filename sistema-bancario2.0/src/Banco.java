import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<ContaBancaria> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(ContaBancaria c) {
        contas.add(c);
    }

    public void removerConta(ContaBancaria c) {
        contas.remove(c);
    }

    public List<ContaBancaria> getContas() {
        return contas;
    }

    public void listarContas() {
        if (!contas.isEmpty()) {
            contas.forEach(c -> {
                System.out.println("----------------------");
                c.verDetalhes();
            });
            System.out.println("----------------------");
        } else {
            System.out.println("Nenhuma conta encontrada.");
        }
    }

}
