package Projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        HashMap<Livro, Set<Livro>> recomendacoes = criarGrafo();
        Stack<Livro> historico = new Stack<>();
        Queue<Livro> listaEspera = new LinkedList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            int escolha;
            
            do {
                System.out.println("============================================");
                System.out.println("1 - Consultar livros");
                System.out.println("2 - Ver meu histórico");
                System.out.println("3 - Ver minha lista de espera");
                System.out.println("4 - Emprestar livro");
                System.out.println("5 - Ver minhas recomendações");
                System.out.println("6 - Sair");
                System.out.print("Bem vindo a biblioteca, o que gostaria de fazer? ");
                escolha = scanner.nextInt();
                
                switch (escolha) {
                    case 1:
                        consultarLivros();
                        break;

                    case 2:
                        consultarHistorico(historico);
                        break;

                    case 3:
                        consultarListaEspera(listaEspera);
                        break;

                    case 4:
                        System.out.print("ID do livro que você gostaria de emprestar: ");
                        int emprestar = scanner.nextInt() - 1;
                        
                        if ((int)(Math.random() * (1 - 0 + 1) + 0) == 1) {
                            System.out.println("Esse livro já foi emprestado, livro adicionado à lista de espera!");
                            listaEspera.add(listaLivros().get(emprestar));
                        } else {
                            historico.add(listaLivros().get(emprestar));
                            System.out.println("Livro emprestado com sucesso!");
                        }
                        
                        break;

                    case 5:
                        consultarRecomendacoes(historico, recomendacoes);
                        break;
                        
                    case 6:
                        escolha = 6;
                        System.out.println("Até a próxima! =)");
                        break;
                        
                    default:
                        break;
                }
            } while (escolha != 6);
        }

        for (Livro livro : recomendacoes.keySet()) {
            System.out.println("Você leu: " + livro.titulo + ". Você pode gostar de: " + recomendacoes.get(livro).toString());
        }
    }

    public static void consultarLivros() {
        ArrayList<Livro> livros = listaLivros();

        for (Livro livro : livros) {
            System.out.println(livro.id + " - " + livro.titulo + " de " + livro.autor + " | " + livro.ano_publicacao);
        }
    }

    public static void consultarHistorico(Stack<Livro> historico) {
        for (int i = historico.size() - 1; i >= 0; i--) {
            Livro livro = historico.get(i);
            System.out.println("- " + livro.titulo + " de " + livro.autor + " | " + livro.ano_publicacao);
        }

        if (historico.isEmpty()) {
            System.out.println("Você ainda não emprestou nenhum livro!");
        }
    }

    public static void consultarListaEspera(Queue<Livro> listaEspera) {
        for (Livro livro : listaEspera) {
            System.out.println("- " + livro.titulo + " de " + livro.autor + " | " + livro.ano_publicacao);
        }

        if (listaEspera.isEmpty()) {
            System.out.println("Você ainda não tem nenhum livro na lista de espera!");
        }
    }

    public static void consultarRecomendacoes(Stack<Livro> historico, HashMap<Livro, Set<Livro>> recomendacoes) {
        for (Livro livro : historico) {
            System.out.println("Você leu: " + livro.titulo + ". Você pode gostar de: " + recomendacoes.get(livro).toString());
        }

        if (historico.isEmpty()) {
            System.out.println("Você ainda não emprestou nenhum livro para ver as recomendações!");
        }
    }

    public static ArrayList<Livro> listaLivros() {
        ArrayList<Livro> livros = new ArrayList<>();

        // Agatha Christie
        Livro nsn = new Livro(1, "E não sobrou nenhum", "Agatha Christie", 1930);
        Livro aeo = new Livro(2, "Assassinato no expresso do oriente", "autor", 1934);

        // Senhor dos Anéis
        Livro sda1 = new Livro(4, "A Sociedade do Anel", "Tolkien", 1954);
        Livro sda2 = new Livro(5, "As Duas Torres", "Tolkien", 1954);
        Livro sda3 = new Livro(6, "O Retorno do Rei", "Tolkien", 1955);
        Livro hobbit = new Livro(3, "Hobbit", "Tolkien", 1970);

        // Crônicas de Nárnia
        Livro narnia1 = new Livro(7, "O Leão, a Feiticeira e o Guarda-Roupa", "C.S. Lewis", 1950);
        Livro narnia2 = new Livro(8, "O Príncipe Caspian", "C.S. Lewis", 1951);

        // Harry Potter
        Livro hp1 = new Livro(9, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997);
        Livro hp2 = new Livro(10, "Harry Potter e a Câmara Secreta", "J.K. Rowling", 1998);

        livros.add(nsn);
        livros.add(aeo);
        livros.add(sda1);
        livros.add(sda2);
        livros.add(sda3);
        livros.add(hobbit);
        livros.add(narnia1);
        livros.add(narnia2);
        livros.add(hp1);
        livros.add(hp2);

        return livros;
    }

    // Função para criar os livros e criar o grafo com as conexões entre os livros
    public static HashMap<Livro, Set<Livro>> criarGrafo() {

        HashMap<Livro, Set<Livro>> recomendacoes = new HashMap<>();
        ArrayList<Livro> livros = listaLivros();
        
        // Conectando Agatha Christie
        conectar(recomendacoes, livros.get(1), livros.get(0));

        // Conectando Senhor dos Anéis/ Hobbit
        conectar(recomendacoes, livros.get(2), livros.get(3));
        conectar(recomendacoes, livros.get(3), livros.get(4));
        conectar(recomendacoes, livros.get(2), livros.get(4));
        conectar(recomendacoes, livros.get(4), livros.get(5));
        conectar(recomendacoes, livros.get(2), livros.get(5));
        conectar(recomendacoes, livros.get(3), livros.get(5));

        // Conectando Nárnia
        conectar(recomendacoes, livros.get(6), livros.get(7));

        // Conectando Harry Potter
        conectar(recomendacoes, livros.get(8), livros.get(9));
        
        // Conectando séries de fantasia
        conectar(recomendacoes, livros.get(2), livros.get(8));
        conectar(recomendacoes, livros.get(2), livros.get(9));
        conectar(recomendacoes, livros.get(6), livros.get(2));
        conectar(recomendacoes, livros.get(7), livros.get(2));

        // Conectando séries "cult"
        conectar(recomendacoes, livros.get(1), livros.get(2));
        conectar(recomendacoes, livros.get(0), livros.get(3));

        return recomendacoes;
    }

    // Função para criar as conexões do grafo
    public static void conectar(HashMap<Livro, Set<Livro>> mapa, Livro a, Livro b) {
        mapa.putIfAbsent(a, new HashSet<>());
        mapa.putIfAbsent(b, new HashSet<>());
        mapa.get(a).add(b);
        mapa.get(b).add(a);
    }
}
