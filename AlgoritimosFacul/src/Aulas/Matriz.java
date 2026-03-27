package Aulas;

public class Matriz {
    public int[][] matriz;

    public Matriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public void adicionar(int lc, int[] valores) {
        switch (lc) {
            case 0 -> adicionarLinha(valores);
            case 1 -> adicionarColuna(valores);
        }
    }

    private void adicionarLinha(int[] valores) {
        int[][] matrizNova = new int[this.matriz.length + 1][this.matriz[0].length];

        for (int i = 0; i < this.matriz.length; i++) for (int j = 0; j < this.matriz[i].length; j++) matrizNova[i][j] = this.matriz[i][j];
            

        for (int j = 0; j < valores.length; j++) matrizNova[matrizNova.length - 1][j] = valores[j];
            
        this.matriz = matrizNova;
    }

    private void adicionarColuna(int[] valores) {
        int[][] matrizNova = new int[this.matriz.length][this.matriz[0].length + 1];
        for (int i = 0; i < this.matriz.length; i++) for (int j = 0; j < this.matriz[i].length; j++) matrizNova[i][j] = this.matriz[i][j];

        for (int j = 0; j < valores.length; j++) matrizNova[j][matrizNova.length] = valores[j];

        this.matriz = matrizNova;
    }

    public void remover(int lc, int index) {
        switch (lc) {
            case 0 -> removerLinha(index);
            case 1 -> removerColuna(index);
        }
    }

    private void removerLinha(int index) {
        int[][] matrizNova = new int[this.matriz.length - 1][this.matriz[0].length];

        for (int i = 0; i < index; i++) {
            for (int j = 0; j < this.matriz[0].length; j++) {
                matrizNova[i][j] = this.matriz[i][j];
            }
        }

        for (int i = index + 1; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[0].length; j++) {
                matrizNova[i - 1][j] = this.matriz[i][j];
            }
        }

        this.matriz = matrizNova;
    }

    private void removerColuna(int index) {
        int[][] matrizNova = new int[this.matriz.length][this.matriz[0].length - 1];

        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < index; j++) {
                matrizNova[i][j] = this.matriz[i][j];
            }

            for (int j = index + 1; j < this.matriz[0].length; j++) {
                matrizNova[i][j - 1] = this.matriz[i][j];
            }
        }

        this.matriz = matrizNova;
    }
}
