package jogo;

import cartas.*;
import cartas.Encantamento;
import jogador.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class CampoDeBatalha {
	private List<Criatura> criaturasNoCampo;
	private List<Encantamento> encantamentosNoCampo;



    public CampoDeBatalha() {
        this.criaturasNoCampo = new ArrayList<>();
    }

    public List<Criatura> getCriaturasNoCampo() {
        return criaturasNoCampo;
    }

    public void setCriaturasNoCampo(List<Criatura> criaturasNoCampo) {
        this.criaturasNoCampo = criaturasNoCampo;
    }

    public void adicionarCriaturaAoCampo(Criatura criatura) {
        this.criaturasNoCampo.add(criatura);
    }

    public void removerCriaturaDoCampo(Criatura criatura) {
        this.criaturasNoCampo.remove(criatura);
    }
    public void adicionarEncantamentoAoCampo(Encantamento encantamento) {
        this.encantamentosNoCampo.add(encantamento);
    }

    public void removerEncantamentos() {
        encantamentosNoCampo.clear();
        System.out.println("Todos os encantamentos foram removidos do campo.");
    }


    public void aplicarEncantamento(Encantamento encantamento, Jogador jogador, Jogador oponente) {
        List<Criatura> criaturas = jogador.getCampoDeBatalha().getCriaturasNoCampo();

        switch (encantamento.getNome()) {
            case "Ovo observador do fortalecimento":
                System.out.println("Aumentando o poder das criaturas no campo do jogador.");
                for (Criatura criatura : criaturas) {
                    criatura.aumentarPoder(2);
                }
                break;

            case "Ovo observador do decaimente":
                System.out.println("Reduzindo o poder das criaturas oponentes.");
                for (Criatura criatura : oponente.getCampoDeBatalha().getCriaturasNoCampo()) {
                    criatura.diminuirPoder(2);
                }
                break;

            case "Ovo observador da provação":
                System.out.println("Reduzindo a resistência das criaturas oponentes.");
                for (Criatura criatura : oponente.getCampoDeBatalha().getCriaturasNoCampo()) {
                    criatura.receberDano(2);
                }
                break;

            case "Ovo observador da resistência":
                System.out.println("Aumentando a resistência das criaturas no campo do jogador.");
                for (Criatura criatura : criaturas) {
                    criatura.aumentarResistencia(2);
                }
                break;

            default:
                System.out.println("Encantamento não reconhecido.");
                break;
        }
    }

    public Cartas removerCartaAleatoria() {
        if (!criaturasNoCampo.isEmpty()) {
            int indice = new Random().nextInt(criaturasNoCampo.size());
            return criaturasNoCampo.remove(indice);
        }
        System.out.println("Nenhuma carta disponível para remover.");
        return null;
    }

    public boolean isEmpty() {
        return this.criaturasNoCampo.isEmpty();
    }

    public int size() {
        return this.criaturasNoCampo.size();
    }

    public Criatura get(int index) {
        return this.criaturasNoCampo.get(index);
    }
}

