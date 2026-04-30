package Projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;


// Eu fiz uma lógica de empréstimo que o livro escolhido tem uma chance de estar disponível
// Caso esteja disponível, o livro será adicionado ao histórico, onde os livros mais recentes aparecerão primeiro
// Caso não esteja disponível, o livro entrará na sua lista de espera, onde ele irá por último na fila
public class Main {
    public static void main(String[] args) {

        // Instanciando o grafo das recomendações, stack do histórico e fila da lista de espera
        HashMap<Livro, Set<Livro>> recomendacoes = criarGrafo();
        Stack<Livro> historico = new Stack<>();
        Queue<Livro> listaEspera = new LinkedList<>();
        ArvoreBinaria catalogoArvore = new ArvoreBinaria();
        for (Livro livro : listaLivros()) {
            catalogoArvore.inserir(livro);
        }

        try (Scanner scanner = new Scanner(System.in)) {
            int escolha;
            
            do {
                // Interface para usuário
                System.out.println("============================================");
                System.out.println("1 - Consultar livros");
                System.out.println("2 - Ver meu histórico");
                System.out.println("3 - Ver minha lista de espera");
                System.out.println("4 - Emprestar livro");
                System.out.println("5 - Ver minhas recomendações");
                System.out.println("6 - Ver livros em ordem alfabética");
                System.out.println("7 - Buscar livro pelo título");
                System.out.println("8 - Sair");
                System.out.print("Bem vindo a biblioteca, o que gostaria de fazer? ");
                escolha = scanner.nextInt();
                
                // Opções
                switch (escolha) {
                    case 1 -> consultarLivros();

                    case 2 -> consultarHistorico(historico);

                    case 3 -> consultarListaEspera(listaEspera);

                    case 4 -> {
                        System.out.print("ID do livro que você gostaria de emprestar: ");
                        int emprestar = scanner.nextInt() - 1;
                        
                        if ((int)(Math.random() * (1 - 0 + 1) + 0) == 1) {
                            System.out.println("Esse livro já foi emprestado, livro adicionado à lista de espera!");
                            listaEspera.add(listaLivros().get(emprestar));
                        } else {
                            historico.add(listaLivros().get(emprestar));
                            System.out.println("Livro emprestado com sucesso!");
                        }
                    }

                    case 5 -> consultarRecomendacoes(historico, recomendacoes);

                    case 6 -> catalogoArvore.exibirEmOrdemAlfabetica();

                    case 7 -> {
                        System.out.print("Digite o título exato do livro: ");
                        scanner.nextLine();
                        String tituloBusca = scanner.nextLine();
                        Livro encontrado = catalogoArvore.buscarPorTitulo(tituloBusca);
                        
                        System.out.println("============================================");
                        if (encontrado != null) {
                            System.out.println("Livro encontrado! " + encontrado.getTitulo() + " de " + encontrado.getAutor());
                        } else {
                            System.out.println("Livro não encontrado no catálogo.");
                        }
                    }
                        
                    case 8 -> {
                        escolha = 6;
                        System.out.println("Até a próxima! =)");
                    }
                }
            } while (escolha != 8);
        }
    }

    // Consultar todos os livros disponíveis
    public static void consultarLivros() {
        ArrayList<Livro> livros = listaLivros();
        
        System.out.println("============================================");

        for (Livro livro : livros) {
            System.out.println(livro.getId() + " - " + livro.getTitulo() + " de " + livro.getAutor() + " | " + livro.getAno_publicacao());
        }
    }

    // Consultar histórico do usuário
    public static void consultarHistorico(Stack<Livro> historico) {

        System.out.println("============================================");

        for (int i = historico.size() - 1; i >= 0; i--) {
            Livro livro = historico.get(i);
            System.out.println("- " + livro.getTitulo() + " de " + livro.getAutor() + " | " + livro.getAno_publicacao());
        }

        if (historico.isEmpty()) {
            System.out.println("Você ainda não emprestou nenhum livro!");
        }
    }

    // Consultar lista de espera do usuário
    public static void consultarListaEspera(Queue<Livro> listaEspera) {

        System.out.println("============================================");

        for (Livro livro : listaEspera) {
            System.out.println("- " + livro.getTitulo() + " de " + livro.getAutor() + " | " + livro.getAno_publicacao());
        }

        if (listaEspera.isEmpty()) {
            System.out.println("Você ainda não tem nenhum livro na lista de espera!");
        }
    }

    // Consultar recomendações do usuário
    public static void consultarRecomendacoes(Stack<Livro> historico, HashMap<Livro, Set<Livro>> recomendacoes) {

        System.out.println("============================================");

        for (Livro livro : historico) {
            System.out.println("Você leu: " + livro.getTitulo() + ". Você pode gostar de:");

            for (Livro livro_recomendado : recomendacoes.get(livro)) {
                System.out.println("   - " + livro_recomendado.getTitulo() + " de " + livro_recomendado.getAutor());
            }
        }

        if (historico.isEmpty()) {
            System.out.println("Você ainda não emprestou nenhum livro para ver as recomendações!");
        }
    }

    // Função para instanciar todos os livros e inseri-los na lista de livros
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

    // Função para criar o grafo com as conexões entre os livros
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

    // Função para criar as conexões do grafo, grafo não direcionado (conexão mútoa)
    public static void conectar(HashMap<Livro, Set<Livro>> mapa, Livro a, Livro b) {
        mapa.putIfAbsent(a, new HashSet<>());
        mapa.putIfAbsent(b, new HashSet<>());
        mapa.get(a).add(b);
        mapa.get(b).add(a);
    }
}
