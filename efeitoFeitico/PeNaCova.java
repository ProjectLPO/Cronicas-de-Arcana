package efeitoFeitico;
import java.util.ArrayList;
import java.util.List;
import cartas.Criatura;
import jogador.*;

public class PeNaCova implements EfeitoFeitico {
    @Override
    public void aplicar(Jogador jogador, Jogador oponente) {
        System.out.println("Removendo criaturas com resistência menor que 3 do campo do oponente.");
        List<Criatura> criaturasRemovidas = new ArrayList<>();
        for (Criatura criatura : oponente.getCampoDeBatalha().getCriaturasNoCampo()) {
            if (criatura.getResistencia() < 3) {
                criaturasRemovidas.add(criatura);
            }
        }
        for (Criatura criatura : criaturasRemovidas) {
            oponente.getCampoDeBatalha().removerCriaturaDoCampo(criatura);
            oponente.enviarCartaParaCemiterio(criatura);
            System.out.println("Criatura removida: " + criatura.getNome());
        }
    }
}