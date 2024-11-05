import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class CardGame {

    private List<String> deck = new ArrayList<>();
    private List<String> playerHand = new ArrayList<>();
    private List<String> opponentHand = new ArrayList<>();
    private Random random = new Random();
    private int playerLife = 20;
    private int opponentLife = 20;

    public CardGame() {
        // Preencher o deck com cartas 
        for (int i = 1; i <= 60; i++) {
            deck.add("Card " + i);
        }
    }

    public void startGame() {
        // 1. Embaralhar o deck
        Collections.shuffle(deck);

        // 2. Compra inicial (exemplo: 5 cartas por jogador)
        for (int i = 0; i < 5; i++) {
            playerHand.add(deck.remove(0));
            opponentHand.add(deck.remove(0));
        }

        // 3. Decisão de início
        boolean playerStarts = random.nextBoolean();
        System.out.println(playerStarts ? "Player starts the game!" : "Opponent starts the game!");
    }

    // Estrutura do turno
    public void playTurn() {
        System.out.println("Start of turn:");
        drawPhase();
        manaPhase();
        mainPhase();
        combatPhase();
        endPhase();
    }

    private void drawPhase() {
        System.out.println("Draw Phase");
        if (!deck.isEmpty()) {
            playerHand.add(deck.remove(0));
            System.out.println("Player drew a card.");
        } else {
            System.out.println("Deck is empty! Game over due to deck exhaustion.");
            // Adicionar lógica para fim de jogo
        }
    }

    private void manaPhase() {
        System.out.println("Mana Phase");
        // Implementar lógica para ganho de mana
    }

    private void mainPhase() {
        System.out.println("Main Phase");
        // Implementar jogadas como invocação de cartas, etc.
    }

    private void combatPhase() {
        System.out.println("Combat Phase");
        // Implementar lógica de combate
    }

    private void endPhase() {
        System.out.println("End Phase");
        // Implementar descarte de cartas se necessário
    }

    // Condição de vitória
    public boolean checkVictory() {
        if (opponentLife <= 0) {
            System.out.println("Player wins by reducing opponent's life!");
            return true;
        } else if (playerLife <= 0) {
            System.out.println("Opponent wins by reducing player's life!");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.startGame();
        // Jogar turnos até vitória
        while (!game.checkVictory()) {
            game.playTurn();
        }
    }
}

//Explicação das Fases do jogo:
//Fase de compra: O jogador compra uma carta do topo do deck.
//Fase de mana: Implementar lógica de mana, como aumento de recursos.
//Fase principal: Permite invocar cartas, lançar feitiços, etc.
//Fase de combate: Implementar ataques e defesas.
//Fase final: Limpar efeitos temporários e verificar condições.
//Condição de vitória:
//Redução da vida do oponente: Implementar lógica que reduz os pontos de vida com base nas ações de combate.
//Esgotamento do deck: Adicione uma verificação se o deck está vazio na fase de compra.

