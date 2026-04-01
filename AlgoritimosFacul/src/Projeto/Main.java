package Projeto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Livro livro1 = new Livro(1, "Não sobrou nenhum", "Agatha Christie", 1930);
        // LinkedList<Livro> livros = new LinkedList<>();
        // livros.add(livro1);
        // livros.add(new Livro(2, "titulo", "autor", 1900));

        // Queue<Livro> filaLivros = new LinkedList<>();
        // filaLivros.add(livro1);

        // Stack<Livro> historicoLivros = new Stack<>();
        // historicoLivros.add(livros.get(1));

        // for (Livro livro : filaLivros) {
        //     System.out.println(livro.titulo);
        // }

        // for (Livro livro : historicoLivros) {
        //     System.out.println(livro.titulo);
        // }

        Livro livro1 = new Livro(1, "Não sobrou nenhum", "Agatha Christie", 1930);
        Livro livro2 = new Livro(2, "titulo", "autor", 1900);
        Livro livro3 = new Livro(3, "Hobbit", "Tolkien", 1970);

        // Senhor dos Anéis
        Livro sda1 = new Livro(4, "A Sociedade do Anel", "Tolkien", 1954);
        Livro sda2 = new Livro(5, "As Duas Torres", "Tolkien", 1954);
        Livro sda3 = new Livro(6, "O Retorno do Rei", "Tolkien", 1955);

        // Crônicas de Nárnia
        Livro narnia1 = new Livro(7, "O Leão, a Feiticeira e o Guarda-Roupa", "C.S. Lewis", 1950);
        Livro narnia2 = new Livro(8, "O Príncipe Caspian", "C.S. Lewis", 1951);

        // Harry Potter
        Livro hp1 = new Livro(9, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997);
        Livro hp2 = new Livro(10, "Harry Potter e a Câmara Secreta", "J.K. Rowling", 1998);

        HashMap<Livro, Set<Livro>> recomendacoes = new HashMap<>();
        
        conectar(recomendacoes, livro1, livro2);
        conectar(recomendacoes, livro2, livro3);

        conectar(recomendacoes, livro3, sda1);
        conectar(recomendacoes, sda1, sda2);
        conectar(recomendacoes, sda2, sda3);

        // Conectando Nárnia
        conectar(recomendacoes, narnia1, narnia2);

        // Conectando Harry Potter
        conectar(recomendacoes, hp1, hp2);
        
        // Opcional: Conectar sagas de fantasia diferentes
        conectar(recomendacoes, sda1, hp1);

        for (Livro livro : recomendacoes.keySet()) {
            System.out.println("Você leu: " + livro.titulo + ". Você pode gostar de: " + recomendacoes.get(livro).toString());
        }
    }

    public static void conectar(HashMap<Livro, Set<Livro>> mapa, Livro a, Livro b) {
        mapa.putIfAbsent(a, new HashSet<>());
        mapa.putIfAbsent(b, new HashSet<>());
        mapa.get(a).add(b);
        mapa.get(b).add(a);
    }
}
