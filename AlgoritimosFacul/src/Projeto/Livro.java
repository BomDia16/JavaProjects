package Projeto;

import java.util.Objects;

public class Livro {
    
    // Atributos

    // Na última vez eu tinha esquecido de deixar os atributos private
    // Agora todos sao privados e possuem getters e setters
    private int id;
    private String titulo;
    private String autor;
    private int ano_publicacao;

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(int ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    // Construtor
    public Livro(int id, String titulo, String autor, int ano_publicacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano_publicacao = ano_publicacao;
    }

    // Sobrescrevendo os métodos equals e hashCode para criar o grafo
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return id == livro.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Sobrescrevendo toString para melhor visualização das informações do livro
    @Override
    public String toString() {
        return this.titulo + " de " + this.autor;
    }
}
