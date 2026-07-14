package service;

import java.util.ArrayList;
import java.util.List;
import model.Transacao; // Importa a entidade do pacote model

public class GerenciadorTransacoes {
    // Lista na memória simulando o banco de dados
    private List<Transacao> listaDeTransacoes;

    public GerenciadorTransacoes() {
        this.listaDeTransacoes = new ArrayList<>();
    }

    // Método para adicionar
    public void adicionar(Transacao transacao) {
        this.listaDeTransacoes.add(transacao);
        System.out.println("Transação adicionada com sucesso!");
    }

    // Método para listar
    public void listarTodas() {
        if (listaDeTransacoes.isEmpty()) {
            System.out.println("Nenhuma transação cadastrada ainda.");
            return;
        }
        System.out.println("\n=== SUAS TRANSAÇÕES ===");
        for (Transacao t : listaDeTransacoes) {
            t.exibirDados();
        }
    }

    // Método para somar tudo
    public double calcularTotal() {
        double total = 0;
        for (Transacao t : listaDeTransacoes) {
            total += t.getValor();
        }
        return total;
    }
}