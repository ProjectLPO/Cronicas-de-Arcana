package efeitoFeitico;
import java.util.Scanner;
import cartas.Cartas;
import jogador.*;
import scan.ScannerGlobal;

public class GatoNeutro implements EfeitoFeitico {
    @Override
   public void aplicar(Jogador jogador, Jogador oponente) {
    	if (!jogador.getMao().isEmpty()) {
    	    Scanner scanner = ScannerGlobal.scanner;
    	    System.out.println("Escolha uma carta para enviar ao cemitério:");
    	    for (int i = 0; i < jogador.getMao().size(); i++) {
    	        System.out.println((i + 1) + ". " + jogador.getMao().get(i).getNome());
    	    }
    	    try {
    	        int escolha = Integer.parseInt(scanner.nextLine()) - 1;
    	        if (escolha >= 0 && escolha < jogador.getMao().size()) {
    	            Cartas descartada = jogador.getMao().remove(escolha);
    	            jogador.enviarCartaParaCemiterio(descartada); // Apenas a carta escolhida é enviada
    	            System.out.println("Carta descartada: " + descartada.getNome());
    	            jogador.comprarCarta();
    	        } else {
    	            System.out.println("Escolha inválida.");
    	        }
    	    } catch (NumberFormatException e) {
    	        System.out.println("Entrada inválida. Nenhuma carta foi descartada.");
    	    }
    	} else {
    	    System.out.println("Mão vazia, nenhuma carta foi descartada.");
    	}
 }
}

