package efeitoFeitico;
import jogador.*;

public class GatoDaMorte implements EfeitoFeitico {
    @Override
    public void aplicar(Jogador jogador, Jogador oponente) {
        System.out.println("Causando 3 de dano ao HP do oponente.");
        oponente.receberDano(3);
    }
}