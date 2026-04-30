package Projeto;

public class No {
    Livro livro;
    No direita;
    No esquerda;

    public No(Livro livro) {
        this.livro = livro;
        this.esquerda = null;
        this.direita = null;
    }
}
