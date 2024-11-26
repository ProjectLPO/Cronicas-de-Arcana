package efeitoFeitico;
import java.util.List;
import java.util.Scanner;
import cartas.Criatura;
import jogador.*;
import scan.ScannerGlobal;

public class QueAbale implements EfeitoFeitico {
    @Override
    public void aplicar(Jogador jogador, Jogador oponente) {
    	System.out.println("Escolha uma criatura do oponente para causar dano equivalente ao seu poder:");
        List<Criatura> criaturasOponentes = oponente.getCampoDeBatalha().getCriaturasNoCampo();
        if (!criaturasOponentes.isEmpty()) {
            for (int i = 0; i < criaturasOponentes.size(); i++) {
                Criatura criatura = criaturasOponentes.get(i);
                System.out.println((i + 1) + ". " + criatura.getNome() + " (Poder: " + criatura.getPoder() + ")");
            }
            try {
                int escolha = Integer.parseInt(ScannerGlobal.scanner.nextLine()) - 1;
                if (escolha >= 0 && escolha < criaturasOponentes.size()) {
                    Criatura alvo = criaturasOponentes.get(escolha);
                    alvo.receberDano(alvo.getPoder());
                    System.out.println("Criatura alvo " + alvo.getNome() + " recebeu dano de " + alvo.getPoder() + ".");
                } else {
                    System.out.println("Escolha inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Nenhuma criatura foi afetada.");
            }
        } else {
            System.out.println("O campo do oponente está vazio.");
        }
    }
}