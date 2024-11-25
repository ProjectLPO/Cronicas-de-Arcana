	import cartas.*;
	import jogador.*;
	import jogo.*;
	import java.util.ArrayList;
	import java.util.List;


	public class Main {
	    public static void main(String[] args) {
	        
	        List<Cartas> colecao = ColecaoDeCartas.obterCartas();

	        
	        Inventario inventarioJogador1 = new Inventario(colecao);
	        Inventario inventarioJogador2 = new Inventario(colecao);

	        
	        Deck deckJogador1 = new Deck(new ArrayList<>(colecao.subList(0, 45)));
	        Deck deckJogador2 = new Deck(new ArrayList<>(colecao.subList(0, 45)));

	        
	        Cemiterio cemiterioJogador1 = new Cemiterio();
	        Cemiterio cemiterioJogador2 = new Cemiterio();

	        
	        CampoDeBatalha campoJogador1 = new CampoDeBatalha();
	        CampoDeBatalha campoJogador2 = new CampoDeBatalha();

	        
	        Jogador jogador1 = new Jogador(
	            "Jogador 1", 20, 1, deckJogador1, new ArrayList<>(), campoJogador1, cemiterioJogador1, inventarioJogador1
	        );
	        Jogador jogador2 = new Jogador(
	            "Jogador 2", 20, 1, deckJogador2, new ArrayList<>(), campoJogador2, cemiterioJogador2, inventarioJogador2
	        );

	        
	        deckJogador1.embaralhar();
	        deckJogador2.embaralhar();
	        
	        System.out.println("Cartas na mão antes da compra:");
	        System.out.println("Jogador 1: " + jogador1.getMao());
	        System.out.println("Jogador 2: " + jogador2.getMao());


	  
	        
	        System.out.println("Deck do Jogador 1 antes da compra: " + jogador1.getDeck());
	        System.out.println("Deck do Jogador 2 antes da compra: " + jogador2.getDeck());


	        
	        System.out.println("=== Estado Inicial do Jogo ===");
	        System.out.println(jogador1.getNome() + " - HP: " + jogador1.getHp() + " - Mana: " + jogador1.getMana());
	        System.out.println("Mão do " + jogador1.getNome() + ": " + jogador1.getMao());
	        System.out.println("\n" + jogador2.getNome() + " - HP: " + jogador2.getHp() + " - Mana: " + jogador2.getMana());
	        System.out.println("Mão do " + jogador2.getNome() + ": " + jogador2.getMao());
	        System.out.println("==============================\n");

	        
	        System.out.println("Inventário do Jogador 1:");
	        jogador1.mostrarInventario();

	        System.out.println("\nJogador 1 adiciona uma carta ao deck:");
	        jogador1.adicionarCartaAoDeck(colecao.get(0)); // Adiciona a primeira carta da coleção ao deck
	        System.out.println("Novo deck do Jogador 1: ");
	        System.out.println(jogador1.getDeck());

	        
	        System.out.println("\n=== Iniciando o Jogo ===");
	        Jogo jogo = new Jogo(jogador1, jogador2);
	        jogo.iniciarJogo();
	    }
	}

