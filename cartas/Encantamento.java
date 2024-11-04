package cartas;

public class Encantamento extends Cartas{
	private String efeitoCont;

	public Encantamento(String nome, int custoDeMana, String descricao, String efeitoCont) {
		super(nome, custoDeMana, descricao);
		this.efeitoCont = efeitoCont;
	}

	
	
}
