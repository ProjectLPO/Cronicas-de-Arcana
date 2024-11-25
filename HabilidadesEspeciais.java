package Habilidades;

public class HabilidadesEspeciais {

	
	    // Enum para tipos de habilidades
	    public enum TipoHabilidade {
	        ATAQUE,
	        DEFESA,
	        SUPORTE,
	        UTILIDADE
	    }

	    private String nome; // Nome da habilidade
	    private String descricao; // Descrição do efeito
	    private TipoHabilidade tipo; // Tipo da habilidade
	    private int custoMana; // Custo de mana para ativar
	    private int cooldown; // Tempo de recarga em turnos
	    private int cooldownAtual; // Turnos restantes para reutilizar

	    // Construtor padrão
	    public HabilidadesEspeciais() {}

	    // Construtor com parâmetros
	    public HabilidadesEspeciais(String nome, String descricao, TipoHabilidade tipo, int custoMana, int cooldown) {
	        this.nome = nome;
	        this.descricao = descricao;
	        this.tipo = tipo;
	        this.custoMana = custoMana;
	        this.cooldown = cooldown;
	        this.cooldownAtual = 0;
	    }

	    // Métodos getters e setters
	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public String getDescricao() {
	        return descricao;
	    }

	    public void setDescricao(String descricao) {
	        this.descricao = descricao;
	    }

	    public TipoHabilidade getTipo() {
	        return tipo;
	    }

	    public void setTipo(TipoHabilidade tipo) {
	        this.tipo = tipo;
	    }

	    public int getCustoMana() {
	        return custoMana;
	    }

	    public void setCustoMana(int custoMana) {
	        this.custoMana = custoMana;
	    }

	    public int getCooldown() {
	        return cooldown;
	    }

	    public void setCooldown(int cooldown) {
	        this.cooldown = cooldown;
	    }

	    public int getCooldownAtual() {
	        return cooldownAtual;
	    }

	    public void setCooldownAtual(int cooldownAtual) {
	        this.cooldownAtual = cooldownAtual;
	    }

	    // Método para ativar habilidade
	    public boolean ativarHabilidade(int manaDisponivel) {
	        if (cooldownAtual > 0) {
	            return false; // Habilidade em cooldown
	        }

	        if (manaDisponivel < custoMana) {
	            return false; // Mana insuficiente
	        }

	        // Ativar habilidade
	        cooldownAtual = cooldown;
	        return true;
	    }

	    // Método para atualizar cooldown
	    public void atualizarCooldown() {
	        if (cooldownAtual > 0) {
	            cooldownAtual--;
	        }
	    
	    }
}
	