package cartas;
import java.util.ArrayList;
import java.util.List;

public class ColecaoDeCartas {
    
    public static List<Cartas> obterCartas() {
        List<Cartas> cartas = new ArrayList<>();

        // Feitiços
        cartas.add(new Feiticos("Limpar encanto", 4, "Elimina cartas de encantamento no campo para ambos os jogadores", "Limpa o campo de encamentos"));
        cartas.add(new Feiticos("Derretimento", 2, "Remove uma carta aleatória do campo inimigo","Remove uma carta"));
        cartas.add(new Feiticos("Sopro final", 5, "Restaura 2 ponto de hp para o jogador", "Restaura 2 pontos de hp"));
        cartas.add(new Feiticos("último folêgo", 2, "Restaura 1 ponto de resistência de uma criatura em campo", ""));
        cartas.add(new Feiticos("Gato da Sorte", 4, "Saque 2 cartas", ""));
        cartas.add(new Feiticos("Gato do Azar", 3, "Remove 1 carta da mão inimiga", ""));
        cartas.add(new Feiticos("Gato Neutro", 2, "Envia uma carta da sua mão ao cemitério e saca uma carta do deck", ""));
        cartas.add(new Feiticos("Gato da Morte", 8, "Causa 3 de dano diretamente ao hp do oponente", ""));
        cartas.add(new Feiticos("A Morte Cobra ", 9, "Causa 3 de dano diretamente ao hp do oponente e jogador", ""));
        cartas.add(new Feiticos("Pé na Cova", 5, "Retira todas as Criaturas do oponente no campo que estejam com a resistência menor que 3", ""));
        cartas.add(new Feiticos("Cura para todos", 4, "Cura 1 ponto de resistência para todas as criaturas em seu campo", ""));
        cartas.add(new Feiticos("Eu de novo", 2, "Pula o turno de combate do oponente", ""));
        cartas.add(new Feiticos("Que Retorne", 3, "Retorna uma carta do Cemitério", ""));
        cartas.add(new Feiticos("Que Abale", 5, "Causa dano a uma criatura no valor de seu poder", ""));
        
        // Criaturas
        cartas.add(new Criatura("Lorellei", 5, "Sereia vingativa com dentes afiados", 7, 6, "Causa dano extra de 1 ponto ao morder"));
        cartas.add(new Criatura("Bibble", 2, "Bolinha de pelos aveludados", 1, 2, "Anula o primeiro ataque a ele"));
        cartas.add(new Criatura("Gato Purpura", 4, "Gato alado com pelugem brilhante", 2,5 , "Come a próximo ataque do oponete e retorna o dano(uma vez a cada 2 turnos)"));
        cartas.add(new Criatura("Gato Vermelho", 3, "Gato engenhoso que gosta de descansar", 1, 4, "Ao receber dano, dobra o poder de uma criatura aliada"));
        cartas.add(new Criatura("Gato Rubro", 1, "Involução do Gato Vermelho, não trabalha", 4, 1, "Ao atacar não causa dano, recebe o valor do ataque em resistência"));
        cartas.add(new Criatura("Portadora das chaves Celestes", 6, "Fada responsável por guardar os portões do Salão Celestial", 5, 9, "Ao ser atacada, bloqueia a criatura atacante por 2 turnos(uma vez a cada 3 turnos)"));
        cartas.add(new Criatura("Mãozinha", 3, "Uma mão ardendo em chamas", 3, 4, "Ao ser derrotado, queima a criatura openente, causando dano de 2 pontos"));
        cartas.add(new Criatura("Regente da Morte", 5, "Figura inigmática", 7, 12, "Ao ser derrotada, mata a criatura oponente"));
        cartas.add(new Criatura("O Comum", 2, "Uma pessoa comum", 3, 5, "É comum"));
        cartas.add(new Criatura("O Extraordinário", 6, "Diz ser extraordinário(não confirmado)", 5, 10, "Muito extraordinário"));
        cartas.add(new Criatura("Regente da Ganância", 5, "Tudo pertence a ela", 8, 10, "Saque 3 cartas"));
        cartas.add(new Criatura("Regente da Paz", 5, "O único fim", 1, 16, "Silencia uma criatura oponente por 1 turno(uma vez a cada 3 turnos)"));
        cartas.add(new Criatura("Regente da Vida", 5, "O valor supremo", 1, 7, "Ao ser derrotada, restaura a resistência completa de uma criatura aliada"));
        cartas.add(new Criatura("O Vizinho", 3, "O vzinho da casa mais próxima", 3, 6, "Esquiva o segunda ataque que recebe"));
        cartas.add(new Criatura("Senhor Porco", 1, "Um porco", 1, 9, "Come o primeiro ataque a ele"));
        cartas.add(new Criatura("O Vigésimo nono", 9, "Número 29 ", 6, 7, "Ao ser derrotado uma vez, ganha 29 de resitência durante 1 turno"));
        cartas.add(new Criatura("Regente do Passado", 5, "Traz a tona o que já se foi", 5, 12, "Ao ser derrotada, devolde uma criatura do cemitério"));
        cartas.add(new Criatura("Regente do Futuro", 5, "Traz o que ainda estava por vir", 5, 12, "Ao entrar em campo, saca uma carta"));
        cartas.add(new Criatura("O Humano", 4, "Um Humano, apenas", 3, 5, "Se outra criatura em campo levar dano fatal, o Humano recebe o dano"));
        cartas.add(new Criatura("Aquele que atravessa o Mundo", 7, "...", 9, 8, "..."));
        cartas.add(new Criatura("Aquele que traz o fim", 7, "...", 12, 10, "..."));
        cartas.add(new Criatura("Pezinho", 3, "Um pé desconhecido congelado", 3, 4, "Ao ser derrotado, congela a criatura oponente por 1 turno"));
        cartas.add(new Criatura("Portadora da Coroa", 6, "Vossa Majestade", 5, 9, "Ao sofrer dano fato, transfere o dano a uma criatura aliada"));
        cartas.add(new Criatura("Aquele que não vai embora", 8, "Não deseja ir", 2, 20, "Possui resistência extra"));
        cartas.add(new Criatura("Gato Azul", 4, "É o Gato Azul", 3, 6, "Bloqueia 2 ataques consecutivos a si"));
        cartas.add(new Criatura("Aquela que deseja ir e levar", 6, "Não ira sozinha", 5, 3, "Ao receber dano fatal, causa dano fataL a uma criatura openente"));
        cartas.add(new Criatura("O Vigésimo quarto", 4, "Número 24", 6, 12, "Quando sua resistência cair a 1, ganha 24 de poder por 1 turno"));
        cartas.add(new Criatura("A Fada Noturna", 7, "Vive a noite", 6, 10, "Escurece a visão do oponente por 1 turno ao ser derrotada"));
        cartas.add(new Criatura("O Primeiro", 6, "Número 1 ", 15, 3, "Imune a habilidades especiais de outrras criatura"));
        

        // Encantamentos
        cartas.add(new Encantamento("Ovo observador do fortalecimento", 3, "Buffa criaturas no campo", "Aumenta o poder das criaturas em 2 pontos por 2 turnos"));
        cartas.add(new Encantamento("Ovo observador crepuscular", 4, "Impede o lançamento de feitiços", "Durante 2 turnos, o oponente não pode lançar feitiços"));
        cartas.add(new Encantamento("Ovo observador do decaimente", 4, "Enfraqueçe forças oponentes", "Durante 2 turnos, o poder das criaturas oponentes decai em 2"));
        cartas.add(new Encantamento("Ovo observador da provação", 3, "Enfraqueçe forças oponentes em hp", "Durante 2 turnos, a resistência das criaturas oponentes é reduzida em 2 pontos"));
        cartas.add(new Encantamento("Ovo observador da resistência", 3, "Aumenta a resistência das criaturas", "Dá resistência extra de 2"));
      

        return cartas;
    }
        
    
}
