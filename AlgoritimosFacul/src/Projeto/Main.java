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

        HashMap<Livro, Set<Livro>> recomendacoes = new HashMap<>();

        recomendacoes.putIfAbsent(livro1, new HashSet<>());
        recomendacoes.get(livro1).add(livro2);
        recomendacoes.putIfAbsent(livro2, new HashSet<>());
        recomendacoes.get(livro2).add(livro1);

        for (Livro livro : recomendacoes.keySet()) {
            System.out.println("Você leu: " + livro.titulo + ". Você pode gostar de: " + recomendacoes.get(livro).toString());
        }
    }
}
