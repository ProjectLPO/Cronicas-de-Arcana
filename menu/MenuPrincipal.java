package menu;

import cartas.*;
import jogador.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import jogo.*;



	public class MenuPrincipal {
	    private Scanner scanner;
	    private List<Inventario> inventarios;

	    public MenuPrincipal() {
	        scanner = new Scanner(System.in);
	        inventarios = new ArrayList<>();
	    }

	    public void iniciar() {
	        while (true) {
	            exibirMenu();
	            int opcao = lerOpcao();
	            executarOpcao(opcao);
	        }
	    }

	    private void exibirMenu() {
	        System.out.println("=== Crônicas de Arcanas ===");
	        System.out.println("1. Novo Jogo");
	        System.out.println("2. Inventário");
	        System.out.println("3. Sair");
	    }

	    private int lerOpcao() {
	        System.out.print("Escolha uma opção: ");
	        return scanner.nextInt();
	    }

	    private void executarOpcao(int opcao) {
	        scanner.nextLine(); 
	        switch (opcao) {
	            case 1:
	                novoJogo();
	                break;
	            case 2:
	                gerenciarInventario();
	                break;
	            case 3:
	                sair();
	                break;
	            default:
	                System.out.println("Opção inválida. Tente novamente.");
	        }
	    }


	        private void novoJogo() {
	            if (inventarios.size() < 2) {
	                System.out.println("É necessário que dois jogadores criem seus inventários primeiro.");
	                return;
	            }

	            System.out.println("Escolha os jogadores:");
	            System.out.println("Jogador 1: ");
	            Inventario inventarioJogador1 = selecionarInventario();
	            System.out.println("Jogador 2: ");
	            Inventario inventarioJogador2 = selecionarInventario();

	            if (inventarioJogador1 == null || inventarioJogador2 == null || inventarioJogador1 == inventarioJogador2) {
	                System.out.println("Seleção inválida. Certifique-se de escolher dois jogadores diferentes.");
	                return;
	            }

	            
	            Jogador jogador1 = new Jogador(
	                inventarioJogador1.getNome(), 
	                20, 
	                0,  
	                inventarioJogador1.getDeck(),
	                new ArrayList<>(), 
	                new CampoDeBatalha(), 
	                new Cemiterio(), 
	                inventarioJogador1
	            );

	            Jogador jogador2 = new Jogador(
	                inventarioJogador2.getNome(), 
	                20, 
	                0, 
	                inventarioJogador2.getDeck(), 
	                new ArrayList<>(), 
	                new CampoDeBatalha(),
	                new Cemiterio(), 
	                inventarioJogador2
	            );

	            
	            Jogo jogo = new Jogo(jogador1, jogador2);
	            jogo.iniciarJogo();
	        

	        System.out.println("Iniciando o jogo com os decks escolhidos!");
	        
	    }
	    private Inventario selecionarInventario() {
	        if (inventarios.isEmpty()) {
	            System.out.println("Nenhum inventário disponível.");
	            return null;
	        }

	        System.out.println("Inventários disponíveis:");
	        for (int i = 0; i < inventarios.size(); i++) {
	            System.out.println((i + 1) + ". " + inventarios.get(i).getNome());
	        }

	        System.out.print("Escolha um número: ");
	        int escolha = scanner.nextInt();
	        scanner.nextLine(); 

	        if (escolha > 0 && escolha <= inventarios.size()) {
	            return inventarios.get(escolha - 1);
	        }

	        System.out.println("Escolha inválida.");
	        return null;
	    }


	    private void gerenciarInventario() {
	        System.out.print("Digite o nome do jogador: ");
	        String nome = scanner.nextLine();


	        for (Inventario inventarioExistente : inventarios) {
	            if (inventarioExistente.getNome().equalsIgnoreCase(nome)) {
	                System.out.println("Jogador já possui um inventário! Você pode criar um novo deck.");
	                inventarioExistente.criarDeck(scanner);
	                return;
	            }
	        }

	        
	        Inventario novoInventario = new Inventario(nome, ColecaoDeCartas.obterCartas());
	        inventarios.add(novoInventario);

	        System.out.println("Bem-vindo, " + nome + "! Crie seu deck:");
	        novoInventario.criarDeck(scanner);
	    }


	    private void sair() {
	        System.out.println("Saindo...");
	        System.exit(0);
	    }
	}


