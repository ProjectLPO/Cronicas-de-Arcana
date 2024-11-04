package cartas;
import java.util.ArrayList;
import java.util.List;

public class ColecaoDeCartas {
    
    public static List<Cartas> obterCartas() {
        List<Cartas> cartas = new ArrayList<>();

        // Feitiços
        cartas.add(new Feiticos("Limpar campo", 4, "Elimina cartas de encantamento no campo para ambos os jogadores", "Limpa o campo de encamentos"));
      

        // Criaturas
        cartas.add(new Criatura("Lorelei", 5, "Sereia vingativa com dentes afiados", 8, 6, "Causa dano ao morder"));
      

        // Encantamentos
        cartas.add(new Encantamento("Fortalecimento", 3, "Buffa criaturas no campo", "Aumenta o poder das criaturas em 2 pontos"));
      

        return cartas;
    }
}
