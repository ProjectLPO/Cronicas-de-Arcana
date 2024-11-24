package cartas;

public abstract class Cartas {
	
	protected String nome;
	protected int custoDeMana;
	protected String descricao;
	
	public Cartas(String nome, int custoDeMana, String descricao) {
		this.nome = nome;
		this.custoDeMana = custoDeMana;
		this.descricao = descricao;
	}

	public abstract void EfeitoDaCarta();

	public String getNome() {
		return nome;
	}



	public int getCustoDeMana() {
		return custoDeMana;
	}


	public String getDescricao() {
		return descricao;
	}
}
