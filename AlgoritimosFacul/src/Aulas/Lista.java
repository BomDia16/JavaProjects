package Aulas;

public class Lista {
    public int[] valores;
    
    public Lista(int[] valores) {
        this.valores = valores;
    }

    public void adicionar(int valor) {
        int[] novo = new int[this.valores.length + 1];
        System.arraycopy(this.valores, 0, novo, 0, this.valores.length);
        novo[this.valores.length] = valor;
        this.valores = novo;
    }

    public void remover(int index) {
        int[] novo = new int[this.valores.length - 1];
        System.arraycopy(this.valores, 0, novo, 0, index);
        System.arraycopy(this.valores, index + 1, novo, index, this.valores.length - index - 1);

        this.valores = novo;
    }

    public int buscaBinaria(int valor) {
        int esquerda = 0;
        int direita = this.valores.length - 1;

        while (esquerda <= direita) { 
            int meio = (esquerda + direita) / 2;

            if (this.valores[meio] == valor) {
                return meio;
            } else if (this.valores[meio] < valor) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return -1;
    }
}
