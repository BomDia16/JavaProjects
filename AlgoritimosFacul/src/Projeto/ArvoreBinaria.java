package Projeto;

public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(Livro livro) {
        raiz = inserirRecursivo(raiz, livro);
    }

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

    public void exibirEmOrdemAlfabetica() {
        System.out.println("============================================");
        System.out.println("Livros ordenados por Título:");
        exibirEmOrdemRecursivo(raiz);
    }

    public void exibirEmOrdemRecursivo(No atual) {
        if (atual != null) {
            exibirEmOrdemRecursivo(atual.esquerda);
            System.out.println("- " + atual.livro.getTitulo() + " (" + atual.livro.getAno_publicacao() + ")");
            exibirEmOrdemRecursivo(atual.direita);
        }
    }

    public Livro buscarPorTitulo(String titulo) {
        No resultado = buscarRecursivo(raiz, titulo);
        return resultado != null ? resultado.livro : null;
    }

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
