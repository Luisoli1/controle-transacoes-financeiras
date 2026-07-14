package main;

import java.util.Locale;
import java.util.Scanner;
import model.Transacao;
import service.GerenciadorTransacoes;

public class Principal {
	public static void main(String[] args) {
		// Instanciamos o leitor do teclado e a nossa classe de serviço
		Scanner teclado = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		GerenciadorTransacoes gerenciador = new GerenciadorTransacoes();
		

		int opcao = 0;

		System.out.println("=== BEM-VINDO AO ASSISTENTE FINANCEIRO CONTROLE-LAR ===");

		// O laço continua rodando enquanto a opção não for 4 (Sair)
		while (opcao != 4) {
			System.out.println("\n--- MENU PRINCIPAL ---");
			System.out.println("1. Adicionar Transação");
			System.out.println("2. Listar Todas as Transações");
			System.out.println("3. Ver Total Gasto");
			System.out.println("4. Sair");
			System.out.print("Escolha uma opção: ");

			opcao = teclado.nextInt();
			teclado.nextLine(); // Limpa o buffer do teclado depois de ler o número

			switch (opcao) {
			case 1:
			    System.out.print("Digite a descrição (Ex: Mercado): ");
			    String descricao = teclado.nextLine();

			    System.out.print("Digite o valor: R$ ");
			    String valorTexto = teclado.nextLine();
			    valorTexto = valorTexto.replace(",", ".");
			    double valor = Double.parseDouble(valorTexto);

			    // Exibe as opções de categoria para o usuário escolher
			    System.out.println("Selecione a categoria:");
			    System.out.println("1. Alimentação");
			    System.out.println("2. Transporte");
			    System.out.println("3. Lazer");
			    System.out.println("4. Moradia");
			    System.out.println("5. Outros");
			    System.out.print("Escolha o número da categoria: ");
			    
			    int opcaoCategoria = teclado.nextInt();
			    teclado.nextLine(); // Limpa o buffer

			    String categoria = "";
			    switch (opcaoCategoria) {
			        case 1: categoria = "Alimentação"; break;
			        case 2: categoria = "Transporte"; break;
			        case 3: categoria = "Lazer"; break;
			        case 4: categoria = "Moradia"; break;
			        default: categoria = "Outros"; break;
			    }

			    // Criamos a entidade com a categoria já definida textualmente
			    Transacao novaTransacao = new Transacao(descricao, valor, categoria);
			    gerenciador.adicionar(novaTransacao);
			    break;

			case 2:
				gerenciador.listarTodas();
				break;

			case 3:
				double total = gerenciador.calcularTotal();
				System.out.printf("\nTotal acumulado de gastos: R$ %.2f\n", total);
				break;

			case 4:
				System.out.println("Encerrando o sistema. Até logo!");
				break;

			default:
				System.out.println("Opção inválida! Tente novamente.");
			}
		}

		teclado.close();
	}
}