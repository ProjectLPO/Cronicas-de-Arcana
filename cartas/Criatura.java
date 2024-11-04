package cartas;

public class Criatura extends Cartas {

	private int poder;
	private int resistencia;
	private String especial;
	
	
	
	
	public Criatura(String nome, int custoDeMana, String descricao, int poder, int resistencia, String especial) {
		super(nome, custoDeMana, descricao);
		this.poder = poder;
		this.resistencia = resistencia;
		this.especial = especial;
	}






	
}
