package Projeto;

// Classe dos nós
public class No {

    // Atributos
    Livro livro;
    No direita;
    No esquerda;

    // Construtor
    public No(Livro livro) {
        this.livro = livro;
        this.esquerda = null;
        this.direita = null;
    }
}
