package jogador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import cartas.*;
import exceptions.DeckCompletoException;
import jogo.*;
import scan.ScannerGlobal;


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
        
        while (mao.size() < 5 && !deck.estaVazio()) {
            comprarCarta();
        }

        
        boolean temCriatura = mao.stream().anyMatch(carta -> carta instanceof Criatura);

        
        if (!temCriatura) {
            while (!deck.estaVazio()) {
                Cartas carta = deck.retirarCarta();
                if (carta instanceof Criatura) {
                    
                    if (mao.size() == 5) {
                        mao.remove(0);
                    }
                    
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
 
    
    	public void colocarCartaNoCampo(int indice, Jogador oponente) {
    	    if (indice < 1 || indice > mao.size()) {
    	        System.out.println("Índice inválido.");
    	        return;
    	    }

    	    Cartas carta = mao.get(indice - 1);

    	    if (carta instanceof Feiticos) {
    	        processarFeitico((Feiticos) carta, oponente);
    	    } else if (carta instanceof Encantamento) {
    	        campoDeBatalha.aplicarEncantamento((Encantamento) carta, this, oponente);
    	    } else if (carta instanceof Criatura) {
    	        campoDeBatalha.adicionarCriaturaAoCampo((Criatura) carta);
    	        System.out.println("Criatura " + carta.getNome() + " foi adicionada ao campo.");
    	    } else {
    	        System.out.println("Tipo de carta não reconhecido: " + carta.getNome());
    	    }

    	    
    	    mao.remove(carta);
    	}

    

    //Cartas para turno inicial
    	public void jogarCartasDoTurno(Jogador oponente) {
    	    Scanner scanner = ScannerGlobal.scanner;
    	    while (true) {
    	        System.out.println(nome + ", escolha uma carta para jogar da sua mão (ou digite 0 para encerrar):");
    	        for (int i = 0; i < mao.size(); i++) {
    	            Cartas carta = mao.get(i);
    	            System.out.println((i + 1) + ". " + carta.getNome() + " (Custo de Mana: " + carta.getCustoDeMana() + ")");
    	        }

    	        int escolha;
    	        try {
    	            escolha = Integer.parseInt(scanner.nextLine());
    	        } catch (NumberFormatException e) {
    	            System.out.println("Escolha inválida. Por favor, insira um número.");
    	            continue;
    	        }

    	        if (escolha == 0) {
    	            System.out.println("Encerrando a fase de jogar cartas.");
    	            break;
    	        }

    	        if (escolha >= 1 && escolha <= mao.size()) {
    	            Cartas cartaEscolhida = mao.get(escolha - 1);
    	            if (mana >= cartaEscolhida.getCustoDeMana()) {
    	                colocarCartaNoCampo(escolha, oponente);
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
    	public void montarDeck() {
    	    Scanner scanner = ScannerGlobal.scanner;
    	    System.out.println("Inventário, " + nome + "! Monte seu deck (mínimo 30 cartas):");
    	    List<Cartas> cartasDisponiveis = inventario.getCartas();

    	    while (deck.getCartasNoDeck().size() < 30) {
    	        System.out.println("\nCartas disponíveis no inventário:");
    	        for (int i = 0; i < cartasDisponiveis.size(); i++) {
    	            System.out.println((i + 1) + ". " + cartasDisponiveis.get(i).getNome() + " (" + cartasDisponiveis.get(i).getDescricao() + ")");
    	        }

    	        System.out.println("\nEscolha uma carta pelo número para adicionar ao deck:");
    	        try {
    	            int escolha = Integer.parseInt(scanner.nextLine()) - 1;

    	            if (escolha >= 0 && escolha < cartasDisponiveis.size()) {
    	                Cartas cartaEscolhida = cartasDisponiveis.get(escolha);

    	                try {
    	                    adicionarCartaAoDeck(cartaEscolhida); 
    	                    cartasDisponiveis.remove(escolha);
    	                } catch (DeckCompletoException e) {
    	                    System.out.println("Erro: " + e.getMessage());
    	                    break; 
    	                }

    	            } else {
    	                System.out.println("Escolha inválida. Tente novamente.");
    	            }

    	        } catch (NumberFormatException e) {
    	            System.out.println("Entrada inválida. Por favor, insira um número.");
    	        }
    	    }

    	    System.out.println("Deck completo! Cartas no deck:");
    	    System.out.println(deck);
    	}





    public void regenerarMana(int turnoAtual) {
 
    	    this.mana =  Math.min(turnoAtual, MANA_MAXIMA);
    	    System.out.println("Jogador " + this.nome + " regenerou mana. Mana atual: " + this.mana);
    	}



    public void adicionarCartaAoDeck(Cartas carta) throws DeckCompletoException {
        if (deck.getCartasNoDeck().size() < 30) {
            deck.adicionarCarta(carta);
            inventario.removerCarta(carta);
            System.out.println("Carta " + carta.getNome() + " adicionada ao deck.");
        }  else {  
            throw new DeckCompletoException("Deck já está completo! Não é possível adicionar mais cartas.");
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

        Scanner scanner = ScannerGlobal.scanner;
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

        Scanner scanner = ScannerGlobal.scanner;
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
    
    //Para feitiço Pular turno
    private boolean pularTurno = false;

    public void pularTurnoDeCombate() {
        this.pularTurno = true;
    }

    public boolean devePularTurnoDeCombate() {
        if (pularTurno) {
            pularTurno = false;
            return true;
        }
        return false;
    }
    
    //Para o feitiço
    public void enviarCartaParaCemiterio(Cartas carta) {
        if (carta != null) {
            cemiterio.adicionarCarta(carta); 
            System.out.println("Carta enviada ao cemitério: " + carta.getNome());
        } else {
            System.out.println("Carta inválida. Não foi possível enviá-la ao cemitério.");
        }
    }

    //Habilita os feitiços
    public void processarFeitico(Feiticos feitico, Jogador oponente) {
        feitico.ativarEfeito(this, oponente);
        enviarCartaParaCemiterio(feitico);
    }

    


    // Combate
    public void processarCombate(List<Criatura> atacantes, List<Criatura> bloqueadores, Jogador oponente) {
        for (int i = 0; i < atacantes.size(); i++) {
            Criatura atacante = atacantes.get(i);

            if (i < bloqueadores.size()) {
                Criatura bloqueador = bloqueadores.get(i);
                System.out.println(atacante.getNome() + " é bloqueado por " + bloqueador.getNome());

                // dano simultâneo
                atacante.receberDano(bloqueador.getPoder());
                bloqueador.receberDano(atacante.getPoder());

                // Remover bloqueador derrotado
                if (bloqueador.getResistencia() <= 0) {
                    campoDeBatalha.removerCriaturaDoCampo(bloqueador);
                    cemiterio.adicionarCarta(bloqueador);
                    System.out.println(bloqueador.getNome() + " foi destruído e enviado ao cemitério.");
                    bloqueadores.remove(i);
                }

                // Remover atacante derrotado
                if (atacante.getResistencia() <= 0) {
                    campoDeBatalha.removerCriaturaDoCampo(atacante);
                    cemiterio.adicionarCarta(atacante);
                    System.out.println(atacante.getNome() + " foi destruído e enviado ao cemitério.");
                    atacantes.remove(i);
                    i--; // Ajustar o índice após remoção da carta
                    continue; 
                }
            } else {
                // Dano direto ao oponente
                System.out.println(atacante.getNome() + " ataca diretamente o jogador oponente.");
                oponente.receberDano(atacante.getPoder());
            }
        }
    }


    public void verificarConsistencia() {
        List<Criatura> criaturasNoCampo = new ArrayList<>(campoDeBatalha.getCriaturasNoCampo());
        for (Criatura criatura : criaturasNoCampo) {
            if (criatura.getResistencia() <= 0) {
                campoDeBatalha.removerCriaturaDoCampo(criatura);
                cemiterio.adicionarCarta(criatura);
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
