package jogador;
import cartas.Cartas;
import cartas.ColecaoDeCartas;
import java.util.ArrayList;
import java.util.List;


public class Deck {
    private List<Cartas> cartas;

    public Deck(List<Cartas> cartas) {
        this.cartas = new ArrayList<>(cartas);
    }

}
