package efeitoFeitico;
import jogador.*;



public class LimparEncanto implements EfeitoFeitico {
    @Override
    public void aplicar(Jogador jogador, Jogador oponente) {
        System.out.println("O campo de encantamentos será limpo para ambos os jogadores.");
        jogador.getCampoDeBatalha().removerEncantamentos();
        oponente.getCampoDeBatalha().removerEncantamentos();
    }
}
