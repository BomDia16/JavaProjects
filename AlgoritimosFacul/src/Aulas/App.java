package Aulas;
public class App {
    public static void main(String[] args) {
        int[] vetor = {7, 7, 9, 9, 10, 10}; 

        int maxContagem = 0;

        for (int i = 0; i < vetor.length; i++) {
            int contagem = 0;
            for (int j = 0; j < vetor.length; j++) {
                if (vetor[j] == vetor[i]) {
                    contagem++;
                }
            }
            if (contagem > maxContagem) {
                maxContagem = contagem;
            }
        }

        int[] modas = new int[vetor.length]; 
        int totalModas = 0;

        for (int i = 0; i < vetor.length; i++) {
            int contagem = 0;
            for (int j = 0; j < vetor.length; j++) {
                if (vetor[j] == vetor[i]) {
                    contagem++;
                }
            }

            if (contagem == maxContagem) {
                
                boolean jaExiste = false;
                for (int k = 0; k < totalModas; k++) {
                    if (modas[k] == vetor[i]) {
                        jaExiste = true;
                    }
                }

                if (!jaExiste) {
                    modas[totalModas] = vetor[i];
                    totalModas++;
                }
            }
        }

        System.out.println("Frequência máxima: " + maxContagem + " aparições.");
        System.out.print("Moda(s): ");
        for (int i = 0; i < totalModas; i++) {
            System.out.print(modas[i] + " ");
        }
        System.out.println();
    }
}