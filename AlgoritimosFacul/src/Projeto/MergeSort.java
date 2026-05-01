package Projeto;

// Classe para método de ordenação MergeSort
public class MergeSort {

    // Contador de operações
    public static long comparacoes = 0;

    // Método para zerar o contador antes da recursão começar
    public static String[] ordenar(String[] oldArr) {
        comparacoes = 0; 
        return ordenarRecursivo(oldArr);
    }

    // Ordenar os valores de maneira recursiva com o método de MergeSort
    private static String[] ordenarRecursivo(String[] oldArr) {

        // Clona a lista de títulos para não alterar a lista original
        String[] arr = oldArr.clone();

        // Dividir a lista e depois 
        if (arr.length < 2) {
            return arr;
        }

        int meio = arr.length / 2;
        String[] esquerda = new String[meio];
        String[] direita = new String[arr.length - meio];

        System.arraycopy(arr, 0, esquerda, 0, meio);
        System.arraycopy(arr, meio, direita, 0, arr.length - meio);

        // Chama a função de novo para dividir mais as listas da direita e da esquerda
        // Bug corrigido: Agora estamos salvando o array ordenado de volta nas variáveis
        esquerda = ordenarRecursivo(esquerda);
        direita = ordenarRecursivo(direita);

        // Juntar as listas
        merge(arr, esquerda, direita);
        return arr;
    }

    // Juntar (merge) das duas listas
    private static void merge(String[] arr, String[] esquerda, String[] direita) {
        int i = 0, j = 0, k = 0;

        while (i < esquerda.length && j < direita.length) {

            // Incrementa a cada comparação feita
            comparacoes++;

            if (esquerda[i].compareTo(direita[j]) <= 0) {
                arr[k++] = esquerda[i++];
            } else {
                arr[k++] = direita[j++];
            }
        }

        while (i < esquerda.length) {
            arr[k++] = esquerda[i++];
        }

        while (j < direita.length) {
            arr[k++] = direita[j++];
        }
    }
}
