package jogador;

import cartas.Cartas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Cartas> cartas;

    public Deck(List<Cartas> cartas) {
        this.cartas = new ArrayList<>(cartas);
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
        return "Deck: " + cartas.toString();
    }
}
