package One;

class Cartas {

    private String nome;
    private int poder;
    private String habilidade;

public class Main{

    public static void main(String[] args) {
        Cartas carta1 = new Cartas("Guerreiro",0, "Machadada");
        Cartas carta2 = new Cartas("Mago",12,"Queimadura");
        carta1.exibirCarta();
        carta2.exibirCarta();
    }
}

// Construtor

    public Cartas(String nome, int poder, String habilidade) {
        this.nome = nome;
        this.poder = poder;
        this.habilidade = habilidade;

    }
    // Método para exibir as informações da carta

    public void exibirCarta() {

        System.out.println("Carta: " + nome);
        System.out.println("Poder: " + poder);
        System.out.println("Habilidade: " + habilidade);
        System.out.println("-------------------------");
    }
}

    public static void main(String[] args) {
        Cartas carta1 = new Cartas("Guerreiro", 0, "Machadada");
        Cartas carta2 = new Cartas("Mago", 12, "Queimadura");
        carta1.exibirCarta();
        carta2.exibirCarta();
    }
}