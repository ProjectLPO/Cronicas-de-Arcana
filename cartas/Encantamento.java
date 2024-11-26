package cartas;

public class Encantamento extends Cartas{
	private String efeitoCont;

	public Encantamento(String nome, int custoDeMana, String descricao, String efeitoCont) {
		super(nome, custoDeMana, descricao);
		this.efeitoCont = efeitoCont;
	}

	  @Override
	    public void efeitoDaCarta() {
	        System.out.println("Efeito contínuo do encantamento: " + efeitoCont);
	      
	    }

	    @Override
	    public String toString() {
	        return "Encantamento [Nome: " + nome + ", Custo de Mana: " + custoDeMana +
	               ", Descrição: " + descricao + ", Efeito Contínuo: " + efeitoCont + "]";
	    }

	
}
