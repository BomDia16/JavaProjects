package Projeto;

// Classe para método de ordenação BubbleSort
public class BubbleSort {

    // Contador de operações
    public static long comparacoes = 0;

    public static String[] ordenar(String[] oldArr) {

        // Zera o contador antes de começar
        comparacoes = 0;

        // Clona a lista de títulos para não alterar a lista original
        String[] arr = oldArr.clone();
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                // Incrementa a cada comparação feita
                comparacoes++;
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Retorna a lista ordenada
        return arr;
    }
}
