package Projeto;

import java.util.Random;

public class GeradorDeNomesLivros {
    private static final int TAMANHO_MAXIMO_DO_NOME = 20;
    private static final String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ";

    public static String[] gerarNomes(int numeroDeLivros) {
        Random random = new Random();
        String[] nomesDeLivros = new String[numeroDeLivros];

        for (int i = 0; i < numeroDeLivros; i++) {
            nomesDeLivros[i] = gerarNomeAleatorio(random);
        }

        // Apenas para fins de teste mostrarei os 10 primeiros nomes
        for (int i = 0; i < 10; i++) {
            System.out.println(nomesDeLivros[i]);
        }

        return nomesDeLivros;
    }

    // Gerar nomes de livros completamente aleatórios
    private static String gerarNomeAleatorio(Random random) {
        int tamanhoDoNome = random.nextInt(TAMANHO_MAXIMO_DO_NOME) + 1;
        StringBuilder sb = new StringBuilder(tamanhoDoNome);

        for (int i = 0; i < tamanhoDoNome; i++) {
            sb.append(ALFABETO.charAt(random.nextInt(ALFABETO.length())));
        }

        return sb.toString();
    }
}
