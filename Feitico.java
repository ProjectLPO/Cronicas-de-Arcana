
public class Feitico {

}
public abstract class Feitico {
    private String nome;
    private int custoMana;
    private int dano;
    private int cura;
    private int turnoCooldown;

    public Feitico(String nome, int custoMana, int dano, int cura, int turnoCooldown) {
        this.nome = nome;
        this.custoMana = custoMana;
        this.dano = dano;
        this.cura = cura;
        this.turnoCooldown = turnoCooldown;
    }

    public String getNome() {
        return nome;
    }

    public int getCustoMana() {
        return custoMana;
    }

    public int getDano() {
        return dano;
    }

    public int getCura() {
        return cura;
    }

    public int getTurnoCooldown() {
        return turnoCooldown;
    }

    public abstract void aplicarEfeito(Jogador alvo);
}

//Tipos de Feitiços

public class FeiticoDeAtaque extends Feitico {
    public FeiticoDeAtaque(String nome, int custoMana, int dano, int turnoCooldown) {
        super(nome, custoMana, dano, 0, turnoCooldown);
    }

    @Override
    public void aplicarEfeito(Jogador alvo) {
        alvo.receberDano(getDano());
    }
}

public class FeiticoDeCura extends Feitico {
    public FeiticoDeCura(String nome, int custoMana, int cura, int turnoCooldown) {
        super(nome, custoMana, 0, cura, turnoCooldown);
    }

    @Override
    public void aplicarEfeito(Jogador alvo) {
        alvo.receberCura(getCura());
    }
}

public class FeiticoDeBuff extends Feitico {
    public FeiticoDeBuff(String nome, int custoMana, int dano, int turnoCooldown) {
        super(nome, custoMana, dano, 0, turnoCooldown);
    }

    @Override
    public void aplicarEfeito(Jogador alvo) {
        alvo.aplicarBuff(getDano());
    }
}

public class FeiticoDeDebuff extends Feitico {
    public FeiticoDeDebuff(String nome, int custoMana, int dano, int turnoCooldown) {
        super(nome, custoMana, dano, 0, turnoCooldown);
    }

    @Override
    public void aplicarEfeito(Jogador alvo) {
        alvo.aplicarDebuff(getDano());
    }
}

//Jogador

public class Jogador {
    private int vida;
    private int mana;
    private int danoBuff;
    private int danoDebuff;

    public Jogador(int vida, int mana) {
        this.vida = vida;
        this.mana = mana;
    }

    public void receberDano(int dano) {
        vida -= dano;
    }

    public void receberCura(int cura) {
        vida += cura;
    }

    public void aplicarBuff(int dano) {
        danoBuff += dano;
    }

    public void aplicarDebuff(int dano) {
        danoDebuff -= dano;
    }

    public int getVida() {
        return vida;
    }

    public int getMana() {
        return mana;
    }

    public int getDanoBuff() {
        return danoBuff;
    }

    public int getDanoDebuff() {
        return danoDebuff;
    }
}


public class Main {
    public static void main(String[] args) {
        Jogador jogador = new Jogador(100, 100);

        Feitico feiticoDeAtaque = new FeiticoDeAtaque("Raio de Fogo", 20, 30, 1);
        Feitico feiticoDeCura = new FeiticoDeCura("Cura Divina", 30, 20, 1);

        jogador.receberDano(feiticoDeAtaque.getDano());
        System.out.println("Vida após ataque: " + jogador.getVida());

        jogador.receberCura(feiticoDeCura.getCura());
        System.out.println("Vida após cura: " + jogador.getVida());
    }
}

