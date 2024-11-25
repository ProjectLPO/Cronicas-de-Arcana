package jogador;

import cartas.Cartas;
import java.util.ArrayList;
import java.util.List;

public class Cemiterio {
    private List<Cartas> cartas;

    public Cemiterio() {
        this.cartas = new ArrayList<>();
    }

    
    public void adicionarCarta(Cartas carta) {
        cartas.add(carta);
    }

   
    public List<Cartas> listarCartas() {
        return new ArrayList<>(cartas);
    }
    public void removerCarta(Cartas carta) {
        if (cartas.remove(carta)) {
            System.out.println("Carta removida do cemitério: " + carta.getNome());
        } else {
            System.out.println("Carta não encontrada no cemitério.");
        }
    }
    public List<Cartas> getCartas() {
        return new ArrayList<>(cartas);
    }
    
    public boolean isEmpty() {
        return cartas.isEmpty();
    }

    @Override
    public String toString() {
        return "Cemitério: " + cartas.toString();
    }
}
