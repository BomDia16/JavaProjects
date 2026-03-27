package Testes;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) throws Exception {
        calcular();
    }

    public static void calcular() {
        boolean continuar = true;

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.print("Digite um número: ");
                int numero1 = scanner.nextInt();
                System.out.print("Digite outro número: ");
                int numero2 = scanner.nextInt();
                System.out.print("Digite a operação que deseja fazer: ");
                int opecacao = scanner.nextInt();

                int resultado = 0;

                switch (opecacao) {
                    case 1  -> resultado = numero1 + numero2;
                    case 2  -> resultado = numero1 - numero2;
                    case 3  -> resultado = numero1 * numero2;
                    case 4  -> resultado = numero1 / numero2;
                    default -> System.out.print("Digite uma operação válida: ");
                } 

                System.out.println("O resultado é " + resultado);

                System.out.print("Quer continuar? (y/n)");
                String pergunta = scanner.next();

                if (pergunta.equals("n")) {
                    continuar = false;
                }
            } while (continuar);
        }
    }
}
