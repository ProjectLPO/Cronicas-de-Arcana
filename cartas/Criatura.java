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
	 @Override
	    public void EfeitoDaCarta() {
	        System.out.println("Habilidade especial da criatura: " + especial);
	        
	    }

	    @Override
	    public String toString() {
	        return "Criatura [Nome: " + nome + ", Custo de Mana: " + custoDeMana +
	               ", Descrição: " + descricao + ", Poder: " + poder +
	               ", Resistência: " + resistencia + ", Habilidade Especial: " + especial + "]";
	    }






	
}
