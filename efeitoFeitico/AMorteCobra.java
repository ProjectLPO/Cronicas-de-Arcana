package efeitoFeitico;
import jogador.Jogador;

public class AMorteCobra implements EfeitoFeitico {
    @Override
    public void aplicar(Jogador jogador, Jogador oponente) {
        System.out.println("Causando 3 de dano ao HP de ambos os jogadores.");
        jogador.receberDano(3);
        oponente.receberDano(3);
    }
}