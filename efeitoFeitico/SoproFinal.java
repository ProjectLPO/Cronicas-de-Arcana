package efeitoFeitico;
import jogador.*;

public class SoproFinal implements EfeitoFeitico {
    @Override
    public void aplicar(Jogador jogador, Jogador oponente) {
        jogador.setHp(jogador.getHp() + 2);
        System.out.println("Jogador " + jogador.getNome() + " recuperou 2 pontos de HP. HP atual: " + jogador.getHp());
    }
}

