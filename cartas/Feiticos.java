package cartas;
import efeitoFeitico.EfeitoFeitico;
import jogador.Jogador;

public class Feiticos extends Cartas  {

	    private EfeitoFeitico efeito;

	    public Feiticos(String nome, int custoDeMana, String descricao, EfeitoFeitico efeito) {
	        super(nome, custoDeMana, descricao);
	        this.efeito = efeito;
	    }

	    public void ativarEfeito(Jogador jogador, Jogador oponente) {
	        if (efeito != null) {
	            efeito.aplicar(jogador, oponente);
	        } else {
	            System.out.println("Nenhum efeito definido para este feitiço.");
	        }
	    }
	    @Override
	    public String toString() {
	        return "Feitico [Nome: " + nome + ", Custo de Mana: " + custoDeMana + 
	               ", Descrição: " + descricao + "]";
	    }

		@Override
		public void efeitoDaCarta() {
			// TODO Auto-generated method stub
			
		}
	}



