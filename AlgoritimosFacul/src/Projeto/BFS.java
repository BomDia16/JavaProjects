package Projeto;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static Livro buscar(No raiz, String tituloDesejado) {
        if (raiz == null) {
            return null;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz); // Adiciona o topo da árvore na fila

        while (!fila.isEmpty()) {
            No node = fila.poll(); // Tira o primeiro da fila

            // Imprime o livro que está sendo visitado agora
            System.out.println("  -> Visitando (BFS): " + node.livro.getTitulo());

            // Verifica se é o livro procurado
            if (node.livro.getTitulo().equalsIgnoreCase(tituloDesejado)) {
                return node.livro; // Encontrou!
            }

            // Se não encontrou, adiciona os filhos à fila para olhar mais tarde (largura)
            if (node.esquerda != null) {
                fila.add(node.esquerda);
            }
            if (node.direita != null) {
                fila.add(node.direita);
            }
        }
        
        return null; // Não encontrou na árvore toda
    }
}
