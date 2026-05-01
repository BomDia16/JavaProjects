package Projeto;

public class BubbleSort {
    public static long comparacoes = 0; // Contador de operações

    public static String[] ordenar(String[] oldArr) {
        comparacoes = 0; // Zera o contador antes de começar
        String[] arr = oldArr.clone();
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparacoes++; // Incrementa a cada comparação feita
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
