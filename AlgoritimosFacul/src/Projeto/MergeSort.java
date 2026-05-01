package Projeto;

public class MergeSort {
    public static long comparacoes = 0; // Contador de operações

    // Método wrapper para zerar o contador antes da recursão começar
    public static String[] ordenar(String[] oldArr) {
        comparacoes = 0; 
        return ordenarRecursivo(oldArr);
    }

    private static String[] ordenarRecursivo(String[] oldArr) {
        String[] arr = oldArr.clone();
        if (arr.length < 2) {
            return arr;
        }

        int meio = arr.length / 2;
        String[] esquerda = new String[meio];
        String[] direita = new String[arr.length - meio];

        System.arraycopy(arr, 0, esquerda, 0, meio);
        System.arraycopy(arr, meio, direita, 0, arr.length - meio);

        // BUG CORRIGIDO: Agora estamos salvando o array ordenado de volta nas variáveis
        esquerda = ordenarRecursivo(esquerda);
        direita = ordenarRecursivo(direita);

        merge(arr, esquerda, direita);
        return arr;
    }

    private static void merge(String[] arr, String[] esquerda, String[] direita) {
        int i = 0, j = 0, k = 0;

        while (i < esquerda.length && j < direita.length) {
            comparacoes++; // Incrementa a cada comparação feita
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
