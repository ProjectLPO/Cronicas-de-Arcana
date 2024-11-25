package Habilidades;

public class HabilidadesEspeciais {

	public HabilidadesEspeciais() {
		// TODO Auto-generated constructor stub
	}

    private String nome; // Nome da habilidade
    private String descricao; // Descrição do efeito
    private TipoHabilidade tipo; // Tipo da habilidade (ex.: Ataque, Defesa, Suporte)
    private int custoMana; // Custo de mana para ativar
    private int cooldown; // Tempo de recarga em turnos
    private int cooldownAtual; // Turnos restantes para reutilizar

    // tipos de habilidades
    public enum TipoHabilidade {
        ATAQUE, DEFESA, SUPORTE, UTILIDADE
    }

    // Construtor
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

    public void reduzirCooldown() {
        if (cooldownAtual > 0) {
            cooldownAtual--;
        }
    }

    public void resetarCooldown() {
        this.cooldownAtual = cooldown;
    }

    // Método para ativar a habilidade
    public boolean ativar(int manaAtual) {
        if (cooldownAtual > 0) {
            System.out.println("Habilidade em recarga! Faltam " + cooldownAtual + " turnos.");
            return false;
        }

        if (manaAtual < custoMana) {
            System.out.println("Mana insuficiente para ativar " + nome + ".");
            return false;
        }

        System.out.println(nome + " foi ativada!");
        this.cooldownAtual = cooldown; // Reseta o cooldown após uso
        return true;
    }

    @Override
    public String toString() {
        return "HabilidadeEspecial{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", tipo=" + tipo +
                ", custoMana=" + custoMana +
                ", cooldown=" + cooldown +
                ", cooldownAtual=" + cooldownAtual +
                '}';
    }
}
