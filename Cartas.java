package One;


public class Cartas {
    String nome;
    int poder;
    String efeito;

       public Cartas(String nome, int poder, String efeito) {
        this.nome = nome;
        this.efeito = efeito;
        this.poder = poder;
    }

   
    public void exibirCarta() {
        System.out.println("Nome: " + nome);
        System.out.println("Poder: " + poder);
        System.out.println("Efeito: " + efeito);
    }
}


       