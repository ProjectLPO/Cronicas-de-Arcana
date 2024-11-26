
public class JogadorImp {

}
//Interfaces


public interface Dialogo {
    void falar(String + "atacar");
}

public interface Jogador extends Dialogo {
    void atacar(Jogador outroJogador);
    void morrer();
}

public interface Chefe extends Dialogo {
    void atacar(Jogador jogador);
    void morrer();
}

public class JogadorImpl implements Jogador {
    private String nome;

    public JogadorImpl(String nome) {
        this.nome = nome;
    }

    @Override
    public void falar(String mensagem) {
        System.out.println(nome + ": " + mensagem);
    }

    @Override
    public void atacar(Jogador outroJogador) {
        falar("Ataquei" + outroJogador.getClass().getSimpleName());
        outroJogador.morrer();
    }

    @Override
    public void morrer() {
        falar("Morri!");
    }
}

public class ChefeImpl implements Chefe {
    private String nome;

    public ChefeImpl(String nome) {
        this.nome = nome;
    }

    @Override
    public void falar(String mensagem) {
        System.out.println(nome + ": " + mensagem);
    }

    @Override
    public void atacar(Jogador jogador) {
        falar("Ataquei o jogador!");
        jogador.morrer();
    }

    @Override
    public void morrer() {
        falar("Fui derrotado!");
    }
}

public class Main {
    public static void main(String[] args) {
        Jogador jogador1 = new JogadorImpl("Jogador 1");
        Jogador jogador2 = new JogadorImpl("Jogador 2");
        Chefe chefe = new ChefeImpl("Chefe");

        jogador1.atacar(jogador2);
        chefe.atacar(jogador1);
        jogador1.atacar(chefe);
    }
}


