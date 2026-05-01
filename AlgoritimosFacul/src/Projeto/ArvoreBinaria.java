package Projeto;

public class ArvoreBinaria {
    // Atributos
    No raiz;

    // Construtor
    public ArvoreBinaria() {
        this.raiz = null;
    }

    // Função base parar inserir um livro na árvore
    public void inserir(Livro livro) {
        raiz = inserirRecursivo(raiz, livro);
    }

    // Função base parar inserir um livro recursivamente
    public No inserirRecursivo(No atual, Livro livro) {
        if (atual == null) {
            return new No(livro);
        }

        if (livro.getTitulo().compareToIgnoreCase(atual.livro.getTitulo()) < 0) {
            atual.esquerda = inserirRecursivo(atual.esquerda, livro);
        } else if (livro.getTitulo().compareToIgnoreCase(atual.livro.getTitulo()) > 0) {
            atual.direita = inserirRecursivo(atual.direita, livro);
        }

        return atual;
    }

    // Função base parar ordenar os livros em ordem alfabética
    public void exibirEmOrdemAlfabetica() {
        System.out.println("============================================");
        System.out.println("Livros ordenados por Título:");
        exibirEmOrdemRecursivo(raiz);
    }

    // Função recursiva para analisar o título de todos os livros e ordenar alfabeticamente
    public void exibirEmOrdemRecursivo(No atual) {
        if (atual != null) {
            exibirEmOrdemRecursivo(atual.esquerda);
            System.out.println("- " + atual.livro.getTitulo() + " (" + atual.livro.getAno_publicacao() + ")");
            exibirEmOrdemRecursivo(atual.direita);
        }
    }

    // Função base parar buscar o livro pelo título
    public Livro buscarPorTitulo(String titulo) {
        No resultado = buscarRecursivo(raiz, titulo);
        return resultado != null ? resultado.livro : null;
    }

    // Função recursiva para percorrer por todos os livros para encontrar o título específico
    private No buscarRecursivo(No atual, String titulo) {
        if (atual == null || atual.livro.getTitulo().equalsIgnoreCase(titulo)) {
            return atual;
        }

        if (atual.livro.getTitulo().compareToIgnoreCase(titulo) > 0) {
            return buscarRecursivo(atual.esquerda, titulo);
        }

        return buscarRecursivo(atual.direita, titulo);
    }
}
