package jogador;
import java.util.ArrayList;
import cartas.*;
import java.util.List;

public class Jogador {
    private String nome;
    private int hp;
    private int mana;
    private Deck deck;
    private List<Cartas> mao;
    private Cemiterio cemiterio;
    private static final int MANA_MAXIMA = 10;

    public Jogador(String nome, int hp, int manaInicial, Deck deck) {
        this.nome = nome;
        this.hp = hp;
        this.mana = manaInicial;
        this.deck = deck;
        this.mao = new ArrayList<>();
        this.cemiterio = new Cemiterio();
    }

    // Método para comprar uma carta do deck
    public void comprarCarta() {
        if (!deck.estaVazio()) {
            Cartas cartaComprada = deck.retirarCarta();
            mao.add(cartaComprada);
            System.out.println(nome + " comprou a carta: " + cartaComprada);
        } else {
            System.out.println(nome + " não pode comprar mais cartas, o deck está vazio.");
        }
    }

    // Método para jogar uma carta da mão
    public void jogarCarta(Cartas carta) {
        if (mao.contains(carta) && mana >= carta.getCustoDeMana()) {
            mao.remove(carta);
            mana -= carta.getCustoDeMana();
            System.out.println(nome + " jogou a carta: " + carta);
            // Aqui você pode adicionar a lógica de mover a carta para o campo de batalha
        } else {
            System.out.println(nome + " não tem mana suficiente ou a carta não está na mão.");
        }
    }

    // Método para regenerar mana a cada turno
    public void regenerarMana(int turnoAtual) {
        mana = Math.min(turnoAtual, MANA_MAXIMA);
        System.out.println(nome + " regenerou mana. Mana atual: " + mana);
    }


    // Método para receber dano
    public void receberDano(int dano) {
        hp -= dano;
        if (hp <= 0) {
            hp = 0;
            System.out.println(nome + " foi derrotado.");
        } else {
            System.out.println(nome + " recebeu " + dano + " de dano. HP atual: " + hp);
        }
    }

    // Método para adicionar uma carta ao cemitério
    public void enviarParaCemiterio(Cartas carta) {
        cemiterio.adicionarCarta(carta);
        System.out.println(carta + " foi enviada para o cemitério de " + nome);
    }

    // Getters e Setters
    public int getHp() {
        return hp;
    }

    public int getMana() {
        return mana;
    }

    public List<Cartas> getMao() {
        return new ArrayList<>(mao);
    }

    public Cemiterio getCemiterio() {
        return cemiterio;
    }
    
    public Deck getDeck() {
    	return	deck;																																																												
    }

    @Override
    public String toString() {
        return "Jogador " + nome + " [HP=" + hp + ", Mana=" + mana + ", Cartas na mão=" + mao.size() + "]";
    }


  

// Método para declarar ataque
public void declararAtaque() {
    if (campoDeBatalha.isEmpty()) {
        System.out.println(nome + " não tem criaturas para atacar.");
        return;
    }

    for (Criatura criatura : campoDeBatalha) {
        System.out.println(nome + " ataca com " + criatura.getNome() + " (Poder: " + criatura.getPoder() + ")");
        // Implementar lógica para o oponente bloquear ou receber o dano direto
    }
}


// Getter e setter para atributos necessários
public String getNome() {
    return nome;
}



public void adicionarCartaNaMao(Cartas carta) {
    mao.add(carta);
}


public boolean temCartasNoCampo() {
    return !campoDeBatalha.isEmpty();
}
}