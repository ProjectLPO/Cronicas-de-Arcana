package efeitoFeitico;
import cartas.Cartas;
import jogador.*;

public class Derretimento implements EfeitoFeitico {
    @Override
    public void aplicar(Jogador jogador, Jogador oponente) {
        if (!oponente.getCampoDeBatalha().isEmpty()) {
            Cartas cartaRemovida = oponente.getCampoDeBatalha().removerCartaAleatoria();
            System.out.println("Carta removida do campo do oponente: " + cartaRemovida.getNome());
            oponente.enviarParaCemiterio(cartaRemovida);
        } else {
            System.out.println("O campo do oponente está vazio. Nada foi removido.");
        }
    }
}
