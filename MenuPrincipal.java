import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner;

    public MenuPrincipal() {
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            exibirMenu();
            int opcao = lerOpcao();
            executarOpcao(opcao);
        }
    }

    private void exibirMenu() {
        System.out.println("Crônicas de Arcanas");
        System.out.println("1. Novo Jogo");
        System.out.println("2. Carregar Jogo");
        System.out.println("3. Opções");
        System.out.println("4. Sair");
    }

    private int lerOpcao() {
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    private void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                novoJogo();
                break;
            case 2:
                carregarJogo();
                break;
            case 3:
                opcoes();
                break;
            case 4:
                sair();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private void novoJogo() {
        System.out.println("Novo jogo iniciado!");
        // Código para iniciar um novo jogo
    }

    private void carregarJogo() {
        System.out.println("Jogo carregado!");
        // Código para carregar um jogo salvo
    }

    private void opcoes() {
        Opcoes opcoes = new Opcoes();
        opcoes.iniciar();
    }

    private void sair() {
        System.out.println("Saindo...");
        System.exit(0);
    }

    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.iniciar();
    }
}

*Opcoes.java*

import java.util.Scanner;

public class Opcoes {
    private Scanner scanner;

    public Opcoes() {
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            exibirOpcoes();
            int opcao = lerOpcao();
            executarOpcao(opcao);
        }
    }

    private void exibirOpcoes() {
        System.out.println("Opções:");
        System.out.println("1. Dificuldade");
        System.out.println("2. Controles");
        System.out.println("3. Voltar");
    }

    private int lerOpcao() {
        System.out.print("Escolha a opção desejada: ");
        return scanner.nextInt();
    }

    private void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                dificuldade();
                break;
            case 2:
                controles();
                break;
            case 3:
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

 // Selecionar nível de dificuldade do jogo
    private void dificuldade() {
        System.out.println("Dificuldade:");
        System.out.println("1. Fácil");
        System.out.println("2. Médio");
        System.out.println("3. Difícil");
        
    }
 // selecionar controles
    private void controles() {
        System.out.println("Controles:");
        System.out.println("1. Teclado");
        System.out.println("2. Mouse");
        
    }
}
