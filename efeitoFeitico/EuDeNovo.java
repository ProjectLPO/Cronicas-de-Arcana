package efeitoFeitico;
import jogador.*;

public class EuDeNovo implements EfeitoFeitico {
    @Override
    public void aplicar(Jogador jogador, Jogador oponente) {
        System.out.println("Pulando o turno de combate do oponente.");
        oponente.pularTurnoDeCombate();
    }
}