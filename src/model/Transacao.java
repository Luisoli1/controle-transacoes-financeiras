package model;

public class Transacao {
    // Atributos
    private String descricao;
    private double valor;
    private String categoria;

    // Construtor
    public Transacao(String descricao, double valor, String categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }

    // Métodos Getters
    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getCategoria() {
        return categoria;
    }

    // Método para exibir as informações formatadas
    public void exibirDados() {
        System.out.printf("- %s | Categoria: %s | Valor: R$ %.2f\n", 
                this.descricao, this.categoria, this.valor);
    }
}