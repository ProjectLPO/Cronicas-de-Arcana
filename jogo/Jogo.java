package jogo;

import java.util.Random;
import java.util.List;
import cartas.Criatura;
import jogador.Jogador;


public class Jogo {
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;
    private int turnoAtual;

    public Jogo(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.turnoAtual = 1; 
        setupInicial();
    }
    public void configurarJogadores()  {
    	System.out.println(jogador1.getNome());
    	System.out.println(jogador2.getNome());
            System.out.println("\nConfiguração para o jogador: " + jogadorAtual.getNome());
            jogadorAtual.montarDeck(); 
        }
    



    private void setupInicial() {
        jogador1.getDeck().embaralhar();
        jogador2.getDeck().embaralhar();

        Random random = new Random();
        jogadorAtual = random.nextBoolean() ? jogador1 : jogador2;
    }

    public void iniciarJogo() {
        System.out.println("Início do jogo! " + jogador1.getNome() + " contra " + jogador2.getNome());
        while (!verificarCondicoesDeVitoria()) {
            System.out.println("Turno " + turnoAtual + " de " + jogadorAtual.getNome());
            executarTurno();
            turnoAtual++; 
        }
        System.out.println("O jogo acabou.");
    }


 
    	private void executarTurno() {
    	    System.out.println(jogadorAtual.getNome() + " inicia seu turno.");

    	   
    	    jogadorAtual.verificarConsistencia();

    	    jogadorAtual.comprarCarta();
    	    jogadorAtual.regenerarMana(turnoAtual);
    	    Jogador oponente = (jogadorAtual == jogador1) ? jogador2 : jogador1;

    	    // Fase de jogar cartas
    	    jogadorAtual.jogarCartasDoTurno(oponente);

    	    // Fase de ataque
    	    jogadorAtual.declararAtaque();
    	    executarCombate();

    	    trocarTurno();
    	}



    private void executarCombate() {
        System.out.println("Fase de Combate: " + jogadorAtual.getNome() + " declara seus ataques.");
        List<Criatura> atacantes = jogadorAtual.declararAtaque();

        Jogador oponente = (jogadorAtual == jogador1) ? jogador2 : jogador1;
        List<Criatura> bloqueadores = oponente.escolherBloqueadores(atacantes);

        jogadorAtual.processarCombate(atacantes, bloqueadores, oponente); 
    }

    private void trocarTurno() {
        jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
    }

    private boolean verificarCondicoesDeVitoria() {
        // Derrota por hp
        if (jogador1.getHp() <= 0 || jogador2.getHp() <= 0) {
            System.out.println("O jogo terminou!");
            if (jogador1.getHp() <= 0) {
                System.out.println(jogador2.getNome() + " venceu!");
            } else {
                System.out.println(jogador1.getNome() + " venceu!");
            }
            return true;
        }

        // Empate para deck vazio
        boolean ambosDecksVazios = jogador1.getDeck().estaVazio() && jogador2.getDeck().estaVazio();
        boolean ambosCamposVazios = jogador1.getCampoDeBatalha().isEmpty() && jogador2.getCampoDeBatalha().isEmpty();

        if (ambosDecksVazios && ambosCamposVazios) {
            System.out.println("O jogo terminou em empate! Ambos os jogadores ficaram sem cartas e sem criaturas no campo.");
            return true;
        }

        return false;
    }

}

