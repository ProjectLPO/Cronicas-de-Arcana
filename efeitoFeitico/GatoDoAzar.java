package efeitoFeitico;
import cartas.Cartas;
import jogador.*;

public class GatoDoAzar implements EfeitoFeitico {
    @Override
    public void aplicar(Jogador jogador, Jogador oponente) {
        if (!oponente.getMao().isEmpty()) {
            Cartas cartaRemovida = oponente.getMao().remove(0); // Remove a primeira carta da mão
            System.out.println("Carta removida da mão do oponente: " + cartaRemovida.getNome());
            oponente.getCemiterio().adicionarCarta(cartaRemovida);
        } else {
            System.out.println("O oponente não possui cartas na mão para remover.");
        }
    }
}