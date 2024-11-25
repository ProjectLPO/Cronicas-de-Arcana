package jogador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import cartas.*;
import jogo.*;


public class Jogador {
    private String nome;
    private int hp;
    private int mana;
    private Deck deck;
    private List<Cartas> mao;
    private CampoDeBatalha campoDeBatalha;
    private Cemiterio cemiterio;
    private static final int MANA_MAXIMA = 10;
    private Inventario inventario;

    
    public Jogador(String nome, int hp, int mana, Deck deck, List<Cartas> mao, CampoDeBatalha campoDeBatalha, Cemiterio cemiterio, Inventario inventario) {
        this.nome = nome;
        this.hp = hp;
        this.mana = mana;
        this.deck = deck;
        this.deck.embaralhar();
        this.mao = mao;
        this.campoDeBatalha = campoDeBatalha;
        this.cemiterio = cemiterio;
        this.inventario = inventario;
        garantirCriaturaNaMao();
    }

    private void garantirCriaturaNaMao() {
        // Comprar cartas até ter 5 cartas na mão
        while (mao.size() < 5 && !deck.estaVazio()) {
            comprarCarta();
        }

        // Verificar se há uma criatura na mão
        boolean temCriatura = mao.stream().anyMatch(carta -> carta instanceof Criatura);

        // Se não houver criatura, substituir uma carta da mão por uma criatura do deck
        if (!temCriatura) {
            while (!deck.estaVazio()) {
                Cartas carta = deck.retirarCarta();
                if (carta instanceof Criatura) {
                    // Remover a primeira carta da mão para abrir espaço
                    if (mao.size() == 5) {
                        mao.remove(0);
                    }
                    // Adicionar a criatura à mão
                    mao.add(carta);
                    System.out.println(nome + " recebeu a criatura inicial: " + carta.getNome());
                    break;
                }
            }
        }
    }

         
    //Para Cartas
    public void comprarCarta() {
        if (!deck.estaVazio()) {
            Cartas cartaComprada = deck.retirarCarta();
            mao.add(cartaComprada);
            System.out.println(nome + " comprou a carta: " + cartaComprada);
        } else {
            System.out.println(nome + " não pode comprar mais cartas, o deck está vazio.");
        }
    }
    public void jogarCarta(Cartas carta) {
        if (carta instanceof Criatura) {
        	this.campoDeBatalha.adicionarCriaturaAoCampo((Criatura) carta);
            System.out.println("Criatura " + carta.getNome() + " foi colocada no campo de batalha.");
        } else if (carta instanceof Feiticos || carta instanceof Encantamento) {
            carta.EfeitoDaCarta(); // Aplica o efeito.
            this.cemiterio.adicionarCarta(carta); 
            System.out.println("Feitiço ou Encantamento " + carta.getNome() + " foi usado.");
        }
        this.mao.remove(carta);
        if (carta instanceof Feiticos || carta instanceof Encantamento) {
            carta.EfeitoDaCarta(); // Aplica o efeito.
            this.cemiterio.adicionarCarta(carta); // Move a carta para o cemitério após o uso.
            System.out.println(carta.getNome() + " foi usado e enviado ao cemitério.");
            this.mao.remove(carta); // Remove a carta da mão.
        }

    }

    //Cartaspara turno inicial
    public void jogarCartasDoTurno() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(nome + ", escolha uma carta para jogar da sua mão (ou digite 0 para encerrar):");
            for (int i = 0; i < mao.size(); i++) {
                Cartas carta = mao.get(i);
                System.out.println((i + 1) + ". " + carta.getNome() + " (Custo de Mana: " + carta.getCustoDeMana() + ")");
            }

            int escolha = Integer.parseInt(scanner.nextLine()) - 1;

            if (escolha == -1) {
                System.out.println("Encerrando a fase de jogar cartas.");
                break;
            }

            if (escolha >= 0 && escolha < mao.size()) {
                Cartas cartaEscolhida = mao.get(escolha);
                if (mana >= cartaEscolhida.getCustoDeMana()) {
                    jogarCarta(cartaEscolhida);
                    mana -= cartaEscolhida.getCustoDeMana();
                    System.out.println("Mana restante: " + mana);
                } else {
                    System.out.println("Mana insuficiente para jogar " + cartaEscolhida.getNome() + ".");
                }
            } else {
                System.out.println("Escolha inválida.");
            }
        }
    }



    public void regenerarMana(int turnoAtual) {
 
    	    this.mana =  Math.min(turnoAtual, MANA_MAXIMA); // Regenera a mana para o valor máximo.
    	    System.out.println("Jogador " + this.nome + " regenerou mana. Mana atual: " + this.mana);
    	}

    

    public void mostrarInventario() {
        inventario.mostrarInventario();
    }



    public void adicionarCartaAoDeck(Cartas carta) {
        if (deck.getCartasNoDeck().size() < 30) {
            deck.adicionarCarta(carta);
            inventario.removerCarta(carta);
            System.out.println("Carta " + carta.getNome() + " adicionada ao deck.");
        } else {
            System.out.println("Deck já está completo! Não é possível adicionar mais cartas.");
        }
    }

    public void enviarParaCemiterio(Cartas carta) {
        cemiterio.adicionarCarta(carta);
        System.out.println(carta + " foi enviada para o cemitério de " + nome);
    }

 // Ataque
    public List<Criatura> declararAtaque() {
        if (campoDeBatalha.isEmpty()) {
            System.out.println(nome + " não tem criaturas para atacar.");
            return new ArrayList<>();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println(nome + ", escolha quais criaturas irão atacar (digite os números separados por vírgula):");
        List<Criatura> criaturasNoCampo = campoDeBatalha.getCriaturasNoCampo();
        for (int i = 0; i < criaturasNoCampo.size(); i++) {
            Criatura criatura = criaturasNoCampo.get(i);
            System.out.println((i + 1) + ". " + criatura.getNome() + " (Poder: " + criatura.getPoder() + ")");
        }

        String input = scanner.nextLine();
        String[] escolhas = input.split(",");
        List<Criatura> criaturasAtacantes = new ArrayList<>();

        for (String escolha : escolhas) {
            int indice = Integer.parseInt(escolha.trim()) - 1;
            if (indice >= 0 && indice < criaturasNoCampo.size()) {
                criaturasAtacantes.add(criaturasNoCampo.get(indice));
                System.out.println("Criatura selecionada para ataque: " + criaturasNoCampo.get(indice).getNome());
            }
        }

        return criaturasAtacantes;
    }

    // Bloqueio
    public List<Criatura> escolherBloqueadores(List<Criatura> atacantes) {
        if (campoDeBatalha.isEmpty()) {
            System.out.println(nome + " não tem criaturas para bloquear.");
            return new ArrayList<>();
        }

        Scanner scanner = new Scanner(System.in);
        List<Criatura> bloqueadores = new ArrayList<>();
        List<Criatura> criaturasNoCampo = campoDeBatalha.getCriaturasNoCampo();

        System.out.println(nome + ", escolha suas criaturas para bloquear os ataques:");
        for (Criatura atacante : atacantes) {
            System.out.println("Atacante: " + atacante.getNome() + " (Poder: " + atacante.getPoder() + ")");
            for (int i = 0; i < criaturasNoCampo.size(); i++) {
                Criatura bloqueador = criaturasNoCampo.get(i);
                System.out.println((i + 1) + ". " + bloqueador.getNome() + " (Poder: " + bloqueador.getPoder() + ", Resistência: " + bloqueador.getResistencia() + ")");
            }

            System.out.println("Digite o número do bloqueador ou 0 para não bloquear:");
            int escolha = Integer.parseInt(scanner.nextLine().trim()) - 1;

            if (escolha >= 0 && escolha < criaturasNoCampo.size()) {
                bloqueadores.add(criaturasNoCampo.get(escolha));
                System.out.println("Bloqueador selecionado: " + criaturasNoCampo.get(escolha).getNome());
            } else {
                System.out.println("Nenhuma criatura foi selecionada para bloquear.");
            }
        }

        return bloqueadores;
    }

    // Combate
    public void processarCombate(List<Criatura> atacantes, List<Criatura> bloqueadores, Jogador oponente) {
        for (int i = 0; i < atacantes.size(); i++) {
            Criatura atacante = atacantes.get(i);

            if (i < bloqueadores.size()) {
                Criatura bloqueador = bloqueadores.get(i);
                System.out.println(atacante.getNome() + " é bloqueado por " + bloqueador.getNome());

                // Dano simultâneo
                atacante.receberDano(bloqueador.getPoder());
                bloqueador.receberDano(atacante.getPoder());

                // Para o cemiterio
                if (atacante.getResistencia() <= 0) {
                    System.out.println(atacante.getNome() + " foi destruído e enviado ao cemitério.");
                    campoDeBatalha.removerCriaturaDoCampo(atacante);
                    cemiterio.adicionarCarta(atacante);
                }
                if (bloqueador.getResistencia() <= 0) {
                    System.out.println(bloqueador.getNome() + " foi destruído e enviado ao cemitério.");
                    campoDeBatalha.removerCriaturaDoCampo(bloqueador);
                    cemiterio.adicionarCarta(bloqueador);
                }
            } else {
                // Dano direto ao oponente
                System.out.println(atacante.getNome() + " ataca diretamente o jogador oponente.");
                oponente.receberDano(atacante.getPoder());
            }
        }
       

    }
    

    // Receber dano do jogador
    public void receberDano(int dano) {
        hp -= dano;
        if (hp <= 0) {
            hp = 0;
            System.out.println(nome + " foi derrotado.");
        } else {
            System.out.println(nome + " recebeu " + dano + " de dano. HP atual: " + hp);
        }
    }
    //Getters
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public List<Cartas> getMao() {
        return mao;
    }

    public void setMao(List<Cartas> mao) {
        this.mao = mao;
    }

    public Cemiterio getCemiterio() {
        return cemiterio;
    }

    public void setCemiterio(Cemiterio cemiterio) {
        this.cemiterio = cemiterio;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCampoDeBatalha(CampoDeBatalha campoDeBatalha) {
        this.campoDeBatalha = campoDeBatalha;
    }


    public String getNome() {
        return nome;
    }

    public boolean temCartasNoCampo() {
        return !campoDeBatalha.isEmpty();
    }

    public int getMana() {
        return mana;
    }
    public CampoDeBatalha getCampoDeBatalha() {
        return campoDeBatalha;
    }
}


