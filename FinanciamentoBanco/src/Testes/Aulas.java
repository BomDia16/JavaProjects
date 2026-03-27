package Testes;
import java.util.Locale;
import java.util.Scanner;

public class Aulas {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(new Locale("pt", "BR"));

        System.out.println("Digite um número inteiro: ");
        int numero = scanner.nextInt();

        for (int i = 1; i <= numero; i++) {
            char asterisco = '*';
            for (int j = 1; j <= i; j++) {
                System.out.print(asterisco);
            }
            System.out.println();
        }

        scanner.close();
    }
}
