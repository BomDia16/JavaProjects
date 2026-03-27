package Aulas;

import java.util.LinkedList;


public class Aula2 {
    public static void main(String[] args) {

        // // vetores
        // int[] vetor = {1, 2, 3};
        // Lista vetor1 = new Lista(vetor);

        // // adicionar
        // vetor1.adicionar(6);
        // System.out.println(Arrays.toString(vetor1.valores));

        // // remover
        // vetor1.remover(0);
        // System.out.println(Arrays.toString(vetor1.valores));

        // System.out.println(vetor1.buscaBinaria(8));

        // // matrizes
        // int[][] valores_matriz = {
        //     {1, 2, 3},
        //     {4, 5, 6}
        // };
        // Matriz matriz = new Matriz(valores_matriz);

        // for (int[] linha : matriz.matriz) {
        //     System.out.println(Arrays.toString(linha));
        // }
        // System.out.println();

        // // adicionar linha
        // int[] add = {0, 2};
        // matriz.adicionar(0, add);

        // for (int[] linha : matriz.matriz) {
        //     System.out.println(Arrays.toString(linha));
        // }
        // System.out.println();

        // // adicionar coluna
        // int[] add_coluna = {4, 7, 0};
        // matriz.adicionar(1, add_coluna);

        // for (int[] linha : matriz.matriz) {
        //     System.out.println(Arrays.toString(linha));
        // }
        // System.out.println();

        // // remover linha
        // matriz.remover(0, 1);
        // for (int[] linha : matriz.matriz) {
        //     System.out.println(Arrays.toString(linha));
        // }
        // System.out.println();

        // // remover coluna
        // matriz.remover(1, 1);
        // for (int[] linha : matriz.matriz) {
        //     System.out.println(Arrays.toString(linha));
        // }

        // Lista encadeada

        ListaEncadeada list = new ListaEncadeada();
        list.append(2);
        list.append(3);
        list.append(1);
        list.append(7);
        list.printList();

        list.remove(7);
        list.printList();

        LinkedList<String> livros = new LinkedList<>();
        livros.add("Harry potter");
        for (String livro : livros) {
            System.out.println(livro);
        }
    }
}
