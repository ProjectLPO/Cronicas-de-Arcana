package jogo;

import java.util.Random;
import jogador.Jogador;
import jogador.Deck;
import cartas.*;

public class Jogo {
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;

    public Jogo(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        setupInicial();
    }

    // Setup para início
    private void setupInicial() {
        System.out.println("Embaralhando os decks...");
        jogador1.getDeck().embaralhar();
        jogador2.getDeck().embaralhar();

        System.out.println("Distribuindo cartas iniciais...");
        for (int i = 0; i < 5; i++) {
            jogador1.comprarCarta();
            jogador2.comprarCarta();
        }

        // Jogador que inicia
        Random random = new Random();
        jogadorAtual = random.nextBoolean() ? jogador1 : jogador2;
        System.out.println("O jogador que começa é: " + jogadorAtual.getNome());
    }

    // Turnos
    public void executarTurno() {
        System.out.println("Turno de " + jogadorAtual.getNome());

        // 1. Fase de Compra
        System.out.println("Fase de Compra: " + jogadorAtual.getNome() + " compra uma carta.");
        jogadorAtual.comprarCarta();

        // 2. Fase de Mana
        System.out.println("Fase de Mana: " + jogadorAtual.getNome() + " ganha um cristal de mana.");
        jogadorAtual.ganharMana();

        // 3. Fase Principal
        System.out.println("Fase Principal: Jogador pode jogar cartas e ativar habilidades.");
        jogadorAtual.jogarCartas(); // Implementar lógica de jogar cartas conforme mana disponível

        // 4. Fase de Combate
        System.out.println("Fase de Combate: " + jogadorAtual.getNome() + " pode atacar.");
        executarCombate();  // Chama a lógica de combate

        // 5. Fase Final
        System.out.println("Fase Final: Turno encerrado.");
        encerrarTurno();
    }

    // Lógica de Combate
    private void executarCombate() {
        System.out.println("Fase de Combate: " + jogadorAtual.getNome() + " declara seus ataques.");
        
   
        jogadorAtual.declararAtaque();

        // bloqueio
        Jogador oponente = (jogadorAtual == jogador1) ? jogador2 : jogador1;

        if (oponente.temCartasNoCampo()) {
            System.out.println(oponente.getNome() + " pode bloquear os ataques.");
            
        } else {
            System.out.println(oponente.getNome() + " não tem criaturas no campo para bloquear. Dano direto!");
            
            oponente.receberDano(calcularDanoTotal(jogadorAtual));
        }
    }

    
    private int calcularDanoTotal(Jogador atacante) {
        int danoTotal = 0;
        for (Criatura criatura : atacante.getCampoDeBatalha()) {
            danoTotal += criatura.getPoder();
        }
        return danoTotal;
    }

    // Encerramento do turno e troca de jogador
    private void encerrarTurno() {
        jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
    }

    // Verifica a condição de vitória
    public boolean verificarCondicoesDeVitoria() {
        if (jogador1.getHp() <= 0) {
            System.out.println("Jogador " + jogador2.getNome() + " venceu!");
            return true;
        } else if (jogador2.getHp() <= 0) {
            System.out.println("Jogador " + jogador1.getNome() + " venceu!");
            return true;
        } else if (jogador1.getDeck().estaVazio() || jogador2.getDeck().estaVazio()) {
            System.out.println("Um jogador ficou sem cartas. O outro jogador venceu!");
            return true;
        }
        return false;
    }

    // Inicia o jogo
    public void iniciarJogo() {
        while (!verificarCondicoesDeVitoria()) {
            executarTurno();
        }
        System.out.println("O jogo acabou.");
    }
}