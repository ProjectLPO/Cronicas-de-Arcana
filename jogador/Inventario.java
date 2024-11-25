package jogador;

import cartas.Cartas;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Inventario {
    private String nome;
    private List<Cartas> colecao;
    private Deck deck;

    public Inventario(String nome, List<Cartas> colecao) {
        this.nome = nome;
        this.colecao = new ArrayList<>(colecao);
        this.deck = new Deck(new ArrayList<>());
    
    }

    public String getNome() {
        return nome;
    }

    public void criarDeck(Scanner scanner) {
        System.out.println("Cartas disponíveis na coleção:");
        for (int i = 0; i < colecao.size(); i++) {
            Cartas carta = colecao.get(i);
            System.out.println((i + 1) + ". " + carta.getNome() + " (Custo de Mana: " + carta.getCustoDeMana() + ")");
        }

        System.out.println("Adicione no mínimo 30 cartas ao seu deck. Digite os números correspondentes ou 0 para finalizar:");
        while (deck.tamanho() < 30) {
            System.out.print("Escolha uma carta (restam " + (30 - deck.tamanho()) + "): ");
            int escolha = scanner.nextInt() - 1;

            if (escolha >= 0 && escolha < colecao.size()) {
                Cartas cartaSelecionada = colecao.get(escolha);
                deck.adicionarCarta(cartaSelecionada);
                System.out.println("Carta adicionada ao deck: " + cartaSelecionada.getNome());
            } else if (escolha == -1 && deck.tamanho() >= 30) {
                break;
            } else {
                System.out.println("Escolha inválida.");
            }
        }

        System.out.println("Deck criado com sucesso!");
    }

    public Deck getDeck() {
        return deck;
    }
    
    public List<Cartas> getCartas() {
        return this.colecao; 
    }

    
    public void removerCarta(Cartas carta) {
        if (this.colecao != null && carta != null) {
            this.colecao.remove(carta);
        }
    }
}

