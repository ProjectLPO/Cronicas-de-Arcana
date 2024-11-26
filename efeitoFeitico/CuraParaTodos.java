package efeitoFeitico;
import cartas.Criatura;
import jogador.*;

public class CuraParaTodos implements EfeitoFeitico {
    @Override
    public void aplicar(Jogador jogador, Jogador oponente) {
        System.out.println("Curando 1 ponto de resistência para todas as criaturas no seu campo.");
        for (Criatura criatura : jogador.getCampoDeBatalha().getCriaturasNoCampo()) {
            criatura.aumentarResistencia(1);
        }
    }
}