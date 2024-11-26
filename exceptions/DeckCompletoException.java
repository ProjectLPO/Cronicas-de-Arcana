package exceptions;

public class DeckCompletoException extends Exception {
    public DeckCompletoException(String mensagem) {
        super("Deck completo!");
    }
}
