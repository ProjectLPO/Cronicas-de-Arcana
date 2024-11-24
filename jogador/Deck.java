package jogador;


import cartas.Cartas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Cartas> cartas;

    public Deck(List<Cartas> cartas) {
        this.cartas = cartas != null ? cartas : new ArrayList<>();
    }

    public void adicionarCarta(Cartas carta) {
        cartas.add(carta);
    }

    public Cartas retirarCarta() {
        if (!cartas.isEmpty()) {
            return cartas.remove(0);
        }
        return null;
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public boolean estaVazio() {
        return cartas.isEmpty();
    }

    public int tamanho() {
        return cartas.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cartas no Deck:\n");
        for (Cartas carta : cartas) {
            sb.append(carta.getNome()).append("\n");
        }
        return sb.toString();
    }

    public List<Cartas> getCartasNoDeck() {
        return cartas; 
    }
}
