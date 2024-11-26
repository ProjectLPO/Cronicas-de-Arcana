package efeitoFeitico;
import jogador.*;

public class GatoDaSorte implements EfeitoFeitico {
    @Override
    public void aplicar(Jogador jogador, Jogador oponente) {
        for (int i = 0; i < 2; i++) {
            jogador.comprarCarta();
        }
        System.out.println(jogador.getNome() + " comprou 2 cartas.");
    }
}