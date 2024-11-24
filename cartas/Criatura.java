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
	 public void receberDano(int dano) {
	        resistencia = Math.max(0, resistencia - dano);

	        System.out.println(getNome() + " recebeu " + dano + " de dano. Resistência atual: " + resistencia);
	    }

	    @Override
	    public String toString() {
	        return "Criatura [Nome: " + nome + ", Custo de Mana: " + custoDeMana +
	               ", Descrição: " + descricao + ", Poder: " + poder +
	               ", Resistência: " + resistencia + ", Habilidade Especial: " + especial + "]";
	    }
		public int getPoder() {
			return poder;
		}
		public void setPoder(int poder) {
			this.poder = poder;
		}
		public int getResistencia() {
			return resistencia;
		}
		public void setResistencia(int resistencia) {
			this.resistencia = resistencia;
		}
		public String getEspecial() {
			return especial;
		}
		public void setEspecial(String especial) {
			this.especial = especial;
		}






	
}
