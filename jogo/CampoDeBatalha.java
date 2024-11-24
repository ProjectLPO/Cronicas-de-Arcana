package jogo;

import cartas.Criatura;
import java.util.ArrayList;
import java.util.List;

public class CampoDeBatalha {
    private List<Criatura> criaturasNoCampo;

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
