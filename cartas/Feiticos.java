package cartas;

public class Feiticos extends Cartas {

	private String efeito;

	public Feiticos(String nome, int custoDeMana, String descricao, String efeito) {
		super(nome, custoDeMana, descricao);
		this.efeito = efeito;
	}
	
	

}
