package cartas;

public class Feiticos extends Cartas {

	private String efeito;

	public Feiticos(String nome, int custoDeMana, String descricao, String efeito) {
		super(nome, custoDeMana, descricao);
		this.efeito = efeito;
	}
	
	public void EfeitoDaCarta() {
        System.out.println("Efeito do feitiço: " + efeito);

    }

    @Override
    public String toString() {
        return "Feitico [Nome: " + nome + ", Custo de Mana: " + custoDeMana + 
               ", Descrição: " + descricao + ", Efeito: " + efeito + "]";
    }
}
	


