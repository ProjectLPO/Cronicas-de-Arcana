

import java.util.ArrayList;
import java.util.List;

public class CampoDeBatalha {
    private List<Carta> mao;
    private List<Carta> campo;
    private List<Carta> cemiterio;
    private List<Carta> deck;

    public CampoDeBatalha() {
        this.mao = new ArrayList<>();
        this.campo = new ArrayList<>();
        this.cemiterio = new ArrayList<>();
        this.deck = new ArrayList<>();
    }

    // Métodos para adicionar cartas às zonas
    public void adicionarNaMao(Carta carta) {
        mao.add(carta);
    }

    public void adicionarNoCampo(Carta carta) {
        campo.add(carta);
    }

    public void enviarParaCemiterio(Carta carta) {
        campo.remove(carta);
        cemiterio.add(carta);
    }

    public void comprarDoDeck() {
        if (!deck.isEmpty()) {
            Carta cartaComprada = deck.remove(0);
            mao.add(cartaComprada);
        } else {
            System.out.println("O deck está vazio!");
        }
    }

    // Getters para visualizar o estado das zonas
    public List<Carta> getMao() {
        return mao;
    }

    public List<Carta> getCampo() {
        return campo;
    }

    public List<Carta> getCemiterio() {
        return cemiterio;
    }

    public List<Carta> getDeck() {
        return deck;
    }
}
