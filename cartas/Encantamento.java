package cartas;

public class Encantamento extends Cartas{
	private String efeitoCont;

	public Encantamento(String nome, int custoDeMana, String descricao, String efeitoCont) {
		super(nome, custoDeMana, descricao);
		this.efeitoCont = efeitoCont;
	}

	  @Override
	    public void EfeitoDaCarta() {
	        System.out.println("Efeito contínuo do encantamento: " + efeitoCont);
	        // Aqui você pode adicionar a lógica de como o efeito contínuo afeta o jogo.
	    }

	    @Override
	    public String toString() {
	        return "Encantamento [Nome: " + nome + ", Custo de Mana: " + custoDeMana +
	               ", Descrição: " + descricao + ", Efeito Contínuo: " + efeitoCont + "]";
	    }

	
}
