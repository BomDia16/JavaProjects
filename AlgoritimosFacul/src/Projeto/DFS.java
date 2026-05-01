package Projeto;

// Classe para fazer busca DFS (Depth-First Search)
public class DFS {
    public static Livro buscar(No node, String tituloDesejado) {
        // Se chegou em um nó nulo, retorna null (não achou neste caminho)
        if (node == null) {
            return null;
        }

        // Imprime o livro que está sendo visitado agora para mostrar o caminho percorrido
        System.out.println("  -> Visitando (DFS): " + node.livro.getTitulo());

        // Verifica se é o livro que estamos procurando
        if (node.livro.getTitulo().equalsIgnoreCase(tituloDesejado)) {
            return node.livro;
        }

        // Se não é, busca recursivamente primeiro pela esquerda
        Livro encontradoEsquerda = buscar(node.esquerda, tituloDesejado);
        if (encontradoEsquerda != null) {
            return encontradoEsquerda;
        }

        // Se não achou na esquerda, busca recursivamente pela direita
        return buscar(node.direita, tituloDesejado);
    }
}
