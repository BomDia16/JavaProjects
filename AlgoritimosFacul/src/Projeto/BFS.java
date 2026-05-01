package Projeto;

import java.util.LinkedList;
import java.util.Queue;

// Classe para fazer busca BFS (Breadth-First Search)
public class BFS {
    public static Livro buscar(No raiz, String tituloDesejado) {
        // Se a raiz for nula, retorna null
        if (raiz == null) {
            return null;
        }

        Queue<No> fila = new LinkedList<>();

        // Adiciona o topo da árvore na fila
        fila.add(raiz);

        while (!fila.isEmpty()) {
            // Tira o primeiro da fila
            No node = fila.poll();

            // Imprime o livro que está sendo visitado agora para mostrar o caminho percorrido
            System.out.println("  -> Visitando (BFS): " + node.livro.getTitulo());

            // Verifica se é o livro procurado
            if (node.livro.getTitulo().equalsIgnoreCase(tituloDesejado)) {
                return node.livro;
            }

            // Se não encontrou, adiciona os filhos à fila para olhar mais tarde (largura)
            if (node.esquerda != null) {
                fila.add(node.esquerda);
            }
            if (node.direita != null) {
                fila.add(node.direita);
            }
        }
        
        // Não encontrou na árvore toda
        return null;
    }
}
