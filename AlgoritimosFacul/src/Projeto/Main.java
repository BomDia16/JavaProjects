package Projeto;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Livro livro1 = new Livro(1, "Não sobrou nenhum", "Agatha Christie", 1930);
        LinkedList<Livro> livros = new LinkedList<>();
        livros.add(livro1);
        livros.add(new Livro(2, "titulo", "autor", 1900));

        Queue<Livro> filaLivros = new LinkedList<>();
        filaLivros.add(livro1);

        Stack<Livro> historicoLivros = new Stack<>();
        historicoLivros.add(livros.get(1));

        for (Livro livro : filaLivros) {
            System.out.println(livro.titulo);
        }

        for (Livro livro : historicoLivros) {
            System.out.println(livro.titulo);
        }
    }
}
