package jogador;

import cartas.Cartas;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Cartas> cartasNoInventario;

    public Inventario(List<Cartas> colecao) {
        this.cartasNoInventario = new ArrayList<>();
    }

    
    public void adicionarCarta(Cartas carta) {
        cartasNoInventario.add(carta);
    }

    
    public void removerCarta(Cartas carta) {
        cartasNoInventario.remove(carta);
    }

    
    public List<Cartas> listarCartas() {
        return new ArrayList<>(cartasNoInventario);
    }

    
    public void mostrarInventario() {
        if (cartasNoInventario.isEmpty()) {
            System.out.println("Inventário vazio.");
        } else {
            System.out.println("Cartas no Inventário:");
            for (Cartas carta : cartasNoInventario) {
                System.out.println(carta.getNome());
            }
        }
    }

    
    public boolean temCarta(Cartas carta) {
        return cartasNoInventario.contains(carta);
    }
}
