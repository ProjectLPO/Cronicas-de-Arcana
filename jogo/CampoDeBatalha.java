package jogo;

import cartas.Cartas;
import java.util.ArrayList;
import java.util.List;
import jogador.Cemiterio;
import jogador.Deck;
import jogador.Jogador;

public class CampoDeBatalha {
    private List<Cartas> mao;
    private List<Cartas> campoDeBatalha;
    private Cemiterio cemiterio;
    private Deck deck;

    public CampoDeBatalha(Deck deck) {
        this.mao = new ArrayList<>();
        this.campoDeBatalha = new ArrayList<>();
        this.cemiterio = new Cemiterio();
        this.deck = deck;
    }

    // Método para mover uma carta do deck para a mão
    public void comprarCarta() {
        if (!deck.estaVazio()) {
            Cartas carta = deck.retirarCarta();
            mao.add(carta);
            System.out.println("Carta comprada: " + carta);
        } else {
            System.out.println("O deck está vazio, não é possível comprar cartas.");
        }
    }

    // Método para jogar uma carta da mão para o campo de batalha
    public boolean jogarCarta(Cartas carta) {
        if (mao.contains(carta)) {
            mao.remove(carta);
            campoDeBatalha.add(carta);
            System.out.println("Carta jogada no campo de batalha: " + carta);
            return true;
        } else {
            System.out.println("A carta não está na mão.");
            return false;
        }
    }

    // Método para enviar uma carta do campo de batalha para o cemitério
    public void enviarParaCemiterio(Cartas carta) {
        if (campoDeBatalha.contains(carta)) {
            campoDeBatalha.remove(carta);
            cemiterio.adicionarCarta(carta);
            System.out.println("Carta movida para o cemitério: " + carta);
        } else {
            System.out.println("A carta não está no campo de batalha.");
        }
    }

    // Método para mostrar o estado do campo de batalha
    public void exibirEstado() {
        System.out.println("Mão: " + mao.size() + " cartas");
        System.out.println("Campo de batalha: " + campoDeBatalha.size() + " cartas");
        System.out.println("Cemitério: " + cemiterio.getCartas().size() + " cartas");
        System.out.println("Cartas restantes no deck: " + deck.getCartas().size());
    }

    // Getters 
    public List<Cartas> getMao() {
        return new ArrayList<>(mao);
    }

    public List<Cartas> getCampoDeBatalha() {
        return new ArrayList<>(campoDeBatalha);
    }

    public Cemiterio getCemiterio() {
        return cemiterio;
    }

    public Deck getDeck() {
        return deck;
    }
}
