package efeitoFeitico;
import cartas.Criatura;
import jogador.*;

public class UltimoFolego implements EfeitoFeitico {
    @Override
    public void aplicar(Jogador jogador, Jogador oponente) {
        if (!jogador.getCampoDeBatalha().getCriaturasNoCampo().isEmpty()) {
            Criatura criaturaCurada = jogador.getCampoDeBatalha().getCriaturasNoCampo().get(0);
            criaturaCurada.receberDano(-1); // Curar 1 ponto de resistência
            System.out.println("Criatura curada: " + criaturaCurada.getNome());
        } else {
            System.out.println("Nenhuma criatura disponível no campo para ser curada.");
        }
    }
}