package Projeto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// Classe para o algorítimo Dijkstra
// Ele foi utilizado para uma nova lógica de recomendações
// Os livros que tem distância 1 do título lido pelo usuário são considerados como alta probabilidade da pessoa gostar
// Se o livro tiver 2 de distância, ele será mostrado como um livro que a pessoa talvez gostar
public class Dijkstra {
    public static Map<Livro, Integer> djikstraSimples(HashMap<Livro, Set<Livro>> grafo, Livro origem) {

        Map<Livro, Integer> distancias = new HashMap<>();

        Queue<Livro> fila = new LinkedList<>();

        // Como não temos pesos entre os nós, o peso padrão é 0
        distancias.put(origem, 0);

        fila.add(origem);

    

        while (!fila.isEmpty()) {

            Livro atual = fila.poll();

            int distanciaAtual = distancias.get(atual);

    

            for (Livro vizinho : grafo.getOrDefault(atual, new HashSet<>())) {

                if (!distancias.containsKey(vizinho)) {

                    distancias.put(vizinho, distanciaAtual + 1);

                    fila.add(vizinho);

                }

            }

        }

        // Retorna as distância dos livros até o livro de origem
        return distancias;

    }
}
