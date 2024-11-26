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
	    public void efeitoDaCarta() {
	        System.out.println("Habilidade especial da criatura: " + especial);
	        
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
		 public void aumentarPoder(int quantidade) {
		        if (quantidade > 0) {
		            this.poder += quantidade;
		            System.out.println(this.getNome() + " teve o poder aumentado em " + quantidade + ". Poder atual: " + this.poder);
		        } else {
		            System.out.println("A quantidade para aumentar o poder deve ser positiva.");
		        }
		    }

		    //Diminui o poder da criatura.
		    public void diminuirPoder(int quantidade) {
		        if (quantidade > 0) {
		            this.poder -= quantidade;
		            if (this.poder < 0) this.poder = 0; // Garantir que o poder não fique negativo
		            System.out.println(this.getNome() + " teve o poder reduzido em " + quantidade + ". Poder atual: " + this.poder);
		        } else {
		            System.out.println("A quantidade para reduzir o poder deve ser positiva.");
		        }
		    }

		    //Aumenta a resistência da criatura.
		   
		    public void aumentarResistencia(int quantidade) {
		        if (quantidade > 0) {
		            this.resistencia += quantidade;
		            System.out.println(this.getNome() + " teve a resistência aumentada em " + quantidade + ". Resistência atual: " + this.resistencia);
		        } else {
		            System.out.println("A quantidade para aumentar a resistência deve ser positiva.");
		        }
		    }

		    //Aplica dano ou cura à resistência da criatura.
		    
		    public void receberDano(int dano) {
		        if (dano > 0) {
		            this.resistencia -= dano;
		            if (this.resistencia <= 0) {
		                this.resistencia = 0; // Garante que não fique negativa
		                System.out.println(this.getNome() + " foi derrotada.");
		            } else {
		                System.out.println(this.getNome() + " recebeu " + dano + " de dano. Resistência atual: " + this.resistencia);
		            }
		        } else if (dano < 0) {
		            int cura = -dano;
		            this.resistencia += cura;
		            System.out.println(this.getNome() + " foi curada em " + cura + " pontos. Resistência atual: " + this.resistencia);
		        }
		    }
}






	

