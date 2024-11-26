package efeitoFeitico;
import java.util.List;
import java.util.Scanner;
import cartas.Cartas;
import jogador.*;
import scan.ScannerGlobal;

public class QueRetorne implements EfeitoFeitico {
	@Override
	public void aplicar(Jogador jogador, Jogador oponente) {
    	if (!jogador.getCemiterio().isEmpty()) {
            System.out.println("Escolha uma carta para retornar do cemitério:");
            List<Cartas> cartasNoCemiterio = jogador.getCemiterio().getCartas();
            for (int i = 0; i < cartasNoCemiterio.size(); i++) {
                System.out.println((i + 1) + ". " + cartasNoCemiterio.get(i).getNome());
            }
            try {
                int escolha = Integer.parseInt(ScannerGlobal.scanner.nextLine()) - 1;
                if (escolha >= 0 && escolha < cartasNoCemiterio.size()) {
                    Cartas retornada = cartasNoCemiterio.get(escolha);
                    jogador.getMao().add(retornada);
                    jogador.getCemiterio().removerCarta(retornada);
                    System.out.println("Carta retornada à mão: " + retornada.getNome());
                } else {
                    System.out.println("Escolha inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Nenhuma carta foi retornada.");
            }
        } else {
            System.out.println("O cemitério está vazio. Nenhuma carta foi retornada.");
        }
    }
}