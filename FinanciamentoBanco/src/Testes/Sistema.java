package Testes;
import java.util.Scanner;

public class Sistema {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("----- MENU PRINCIPAL -----");
            System.out.println("1. Estudantes");
            System.out.println("2. Disciplinas");
            System.out.println("3. Professores");
            System.out.println("4. Turmas");
            System.out.println("5. Matrículas");
            System.out.println("6. Sair");
            System.out.print("Digite o número da área que gostaria de acessar: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            if (opcao >= 1 && opcao <= 5) {
                menuOperacoes(opcao);
            } else if (opcao == 6) {
                System.out.println("Até mais!");
                continuar = false;
            } else {
                System.out.println("Insira uma opção válida!");
            }
        }
    }

    public static void menuOperacoes(int opcaoArea) {
        boolean operacoes = true;
        String area = switch (opcaoArea) {
            case 1 -> "ESTUDANTES";
            case 2 -> "DISCIPLINAS";
            case 3 -> "PROFESSORES";
            case 4 -> "TURMAS";
            case 5 -> "MATRICULAS";
            default -> "";
        };

        while (operacoes) {
            System.out.println("----- FUNCIONALIDADES PARA " + area + " -----");
            System.out.println("1. Incluir");
            System.out.println("2. Listar");
            System.out.println("3. Atualizar");
            System.out.println("4. Excluir");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Digite a opção desejada: ");

            int funcionalidade = Integer.parseInt(scanner.nextLine());

            switch (funcionalidade) {
                case 1 -> System.out.println("Chamar método de inserção aqui...");
                case 2 -> System.out.println("Chamar método de listagem aqui...");
                case 3 -> System.out.println("Chamar método de atualização aqui...");
                case 4 -> System.out.println("Chamar método de exclusão aqui...");
                case 5 -> operacoes = false;
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
