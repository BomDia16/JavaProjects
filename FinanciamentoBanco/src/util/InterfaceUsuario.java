package util;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Financiamento;

public class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);

    public int menuPrincipal() {
        System.out.println("Bem vindo ao Banco Financiamentos");
        System.out.println("O que gostaria de fazer hoje?");
        System.out.println("1 - Ver financiamentos do arquivo de texto");
        System.out.println("2 - Ver financiamentos do arquivo serializado");
        System.out.println("3 - Criar novo financiamento");
        System.out.println("4 - Sair");

        boolean errado = true;
        int escolha = 0;

        while (errado) {
            try {
                escolha = scanner.nextInt();

                if (escolha > 0 && escolha < 5) {
                    errado = false;
                }
            } catch (Exception e) {
                System.out.println("Insira um valor válido!");
                scanner.nextLine();
            }
        }
        
        return escolha;
    }

    public double pedirValorImovel() {
        boolean errado = true;
        double valorImovel = 0;

        // Condicional para verificar se o valor informado é maior que 0
        while (errado) {
            try {
                System.out.print("Informe o valor do imóvel: ");
                valorImovel = scanner.nextDouble();

                // Escapar do loop
                if (valorImovel > 50000) {
                    errado = false;
                }
            } catch (Exception e) {
                System.out.println("Insira um valor válido!");
                scanner.nextLine();
            }
        }
        
        return valorImovel;
    }

    public double pedirTaxaJurosAnual() {
        boolean errado = true;
        double taxaJurosAnual = 0;

        // Condicional para verificar se o valor informado é maior que 0
        while (errado) {
            try {
                System.out.print("Informe o valor da taxa anual em porcentagem: ");
                taxaJurosAnual = scanner.nextDouble();

                // Escapar do loop
                if (taxaJurosAnual > 0 && taxaJurosAnual < 100) {
                    errado = false;
                } else {
                    System.out.println("Taxa de juros muito alta ou negativa, insira uma taxa anual válida");
                }
            } catch (Exception e) {
                System.out.println("Insira um valor válido!");
                scanner.nextLine();
            }
        }

        return taxaJurosAnual;
    }

    public int pedirPrazoFinanciamento() {
        boolean errado = true;
        int prazoFinanciamento = 0;

        // Condicional para verificar se o valor informado é maior que 0
        while (errado) {
            try {
                System.out.print("Informe o valor do prazo do financiamento em anos: ");
                prazoFinanciamento = scanner.nextInt();

                // Escapar do loop
                if (prazoFinanciamento > 0) {
                    errado = false;
                }
            } catch (Exception e) {
                System.out.println("Insira um valor válido!");
                scanner.nextLine();
            }
        }

        return prazoFinanciamento;
    }

    public int pedirTipoImovel() {
        int tipoImovel = 0;
        boolean errado = true;

        // Condicional para verificar se o valor informado é correto
        while (errado) {
            try {
                System.out.println("1 - Casa");
                System.out.println("2 - Apartamento");
                System.out.println("3 - Terreno");
                System.out.print("Insira qual é o tipo do imóvel para financiar: ");
                tipoImovel = scanner.nextInt();

                // Escapar do loop
                if (tipoImovel > 0 && tipoImovel < 4) {
                    errado = false;
                }
            } catch (Exception e) {
                System.out.println("Insira um valor válido!");
                scanner.nextLine();
            }
        }

        return tipoImovel;
    }

    public double pedirAreaTerreno() {
        double areaTerreno = 0;
        boolean errado = true;

        // Condicional para verificar se o valor informado é maior que 0
        while (errado) {
            try {
                System.out.print("Insira o valor da área do terreno: ");
                areaTerreno = scanner.nextDouble();

                // Escapar do loop
                if (areaTerreno > 0) {
                    errado = false;
                }
            } catch (Exception e) {
                System.out.println("Insira um valor válido!");
                scanner.nextLine();
            }
        }

        return areaTerreno;
    }

    public double pedirAreaConstruida() {
        double areaConstruida = 0;
        boolean errado = true;

        // Condicional para verificar se o valor informado é maior que 0
        while (errado) {
            try {
                System.out.print("Insira o valor da área construida: ");
                areaConstruida = scanner.nextDouble();

                // Escapar do loop
                if (areaConstruida > 0) {
                    errado = false;
                }
            } catch (Exception e) {
                System.out.println("Insira um valor válido!");
                scanner.nextLine();
            }
        }

        return areaConstruida;
    }

    public int pedirNumeroAndar() {
        int numeroAndar = 0;
        boolean errado = true;

        // Condicional para verificar se o valor informado é maior que 0
        while (errado) {
            try {
                System.out.print("Insira o número do andar do apartamento: ");
                numeroAndar = scanner.nextInt();

                // Escapar do loop
                if (numeroAndar > 0) {
                    errado = false;
                }
            } catch (Exception e) {
                System.out.println("Insira um valor válido!");
                scanner.nextLine();
            }
        }

        return numeroAndar;
    }

    public int pedirNumeroVagas() {
        int numeroVagas = 0;
        boolean errado = true;

        // Condicional para verificar se o valor informado é maior que 0
        while (errado) {
            try {
                System.out.print("Insira o número do vagas do apartamento: ");
                numeroVagas = scanner.nextInt();

                // Escapar do loop
                if (numeroVagas > 0) {
                    errado = false;
                }
            } catch (Exception e) {
                System.out.println("Insira um valor válido!");
                scanner.nextLine();
            }
        }

        return numeroVagas;
    }

    public String pedirTipoZona() {
        String tipoZona = "";
        boolean errado = true;

        // Condicional para verificar se o valor informado é formado apenas de letras
        while (errado) {
            try {
                System.out.print("Insira o tipo da zona em que o terreno se encontra: ");
                tipoZona = scanner.next();

                // Escapar do loop
                if (!tipoZona.isBlank() && tipoZona.matches("[a-zA-Z]+")) {
                    errado = false;
                }
            } catch (Exception e) {
                System.out.println("Insira um valor válido!");
                scanner.nextLine();
            }
        }

        return tipoZona;
    }

    // Lendo financiamentos do documento serializado
    public ArrayList<Financiamento> lerDocumentoSerialized() {
        ArrayList<Financiamento> listaRecuperada = null;
        
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("serialized.test"));

            // Aqui você recupera a lista toda de uma vez
            listaRecuperada = (ArrayList<Financiamento>) inputStream.readObject();

            if (listaRecuperada == null) {
                System.out.println("Não há financiamentos cadastrados!");
                listaRecuperada = new ArrayList<>();
            }

            inputStream.close();

        } catch (EOFException e) {
            System.out.println("Fim do arquivo!");
        } catch (IOException e) {
           System.out.println("Houve problema no processo de leitura do arquivo!");
        } catch (ClassNotFoundException e) {
            System.out.println("Não foi possível ler o arquivo!");
        }

        return listaRecuperada;
    }

    // Escrevendo financiamentos Serialized
    public void escreverDocumentoSerialized(ArrayList<Financiamento> todosFinanciamentos) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("serialized.test"));

            outputStream.writeObject(todosFinanciamentos);
            outputStream.flush();
            outputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException e) {
            System.out.println("Ocorreu algum erro com o escritor.");
        }
    }

    // Ler financiamentos do documento .txt
    public void lerDocumentoTexto() {
        try {
            InputStreamReader leitor = new InputStreamReader(new FileInputStream("financiamentos.txt"), "UTF-8");
            int c = 0;

            while (c != -1) {
                c = leitor.read();
                if (c != -1)
                    System.out.print((char)c);
            }
            leitor.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException e) {
            System.out.println("Ocorreu algum erro com o leitor.");
        }
    }

    // Escrevendo financiamentos em forma de texto
    public void escreverDocumentoTexto(ArrayList<Financiamento> financiamentos) {
        try {

            if (financiamentos != null) {
                OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream("financiamentos.txt"), "UTF-8");
    
                for (Financiamento f : financiamentos) {
                    escritor.write(f.getDadosFinanciamento() + "\n");
                    escritor.write("----------------------------------------------------------------- \n");
                }

                escritor.flush();
                escritor.close();                
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException e) {
            System.out.println("Ocorreu algum erro com o escritor de texto.");
        }
    }
}
