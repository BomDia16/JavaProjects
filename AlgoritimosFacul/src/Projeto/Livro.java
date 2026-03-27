package Projeto;
public class Livro {
    int id;
    String titulo;
    String autor;
    int ano_publicacao;

    public Livro(int id, String titulo, String autor, int ano_publicacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano_publicacao = ano_publicacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return id == livro.id;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }

    @Override
    public String toString() {
        return (this.titulo + " de " + this.autor + " " + this.ano_publicacao).toString();
    }
}
