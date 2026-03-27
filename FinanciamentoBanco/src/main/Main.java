// Artur Barbosa de Oliveira
// Análise e Desenvolvimento de Sistemas

// Esse sistema salva os financiamentos tanto no arquivo serialized.test quanto no financiamentos.txt
// No menu é possível vizualisar e criar novos financiamentos

package main;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;

public class Main {
    public static void main(String[] args) throws Exception {
        // Instanciando a interface
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // Criando um ArrayList de todos os financiamentos
        ArrayList<Financiamento> todosFinanciamentos = new ArrayList<>();
        todosFinanciamentos = interfaceUsuario.lerDocumentoSerialized();
        if (todosFinanciamentos == null) {
            todosFinanciamentos = new ArrayList<>();
        }
        
        // Inserindo os dados dos financiamentos no arquivo "financiamentos.txt"
        interfaceUsuario.escreverDocumentoTexto(todosFinanciamentos);

        // Formatador de valores
        Locale localeBR = new Locale("pt", "BR");
        NumberFormat formatterBRL = NumberFormat.getCurrencyInstance(localeBR);
        
        boolean continuar = true;

        do {
            // Instanciar menu principal
            int escolha = interfaceUsuario.menuPrincipal();

            switch (escolha) {

                // Ler financiamentos do arquivo .txt
                case 1 -> {
                    interfaceUsuario.lerDocumentoTexto();
                }

                // Ler financiamentos do arquivo serializado
                case 2 -> {
                    // Verifica se a lista está vazia
                    if (todosFinanciamentos == null || todosFinanciamentos.isEmpty()) {
                        System.out.println("Não há financiamentos cadastrados!");
                        todosFinanciamentos = new  ArrayList<>();
                        break;
                    }

                    // Variáveis que armazenam o total do valor dos imóveis e o total do valor dos financiamentos
                    double totalImoveis = 0;
                    double totalFinanciamentos = 0;
                    String totalImoveisFormatado;
                    String totalFinanciamentosFormatado;

                    // Exibição de todos os financiamentos na tela
                    for (Financiamento f : todosFinanciamentos) {

                        // Somar o valor do imóvel e do total do financiamento para as variáveis totalImoveis e totalFinanciamentos
                        totalImoveis += f.getValorImovel();
                        totalFinanciamentos += f.getTotalPagamento();

                        String informacoesFinanciamento = f.getDadosFinanciamento();

                        System.out.println(informacoesFinanciamento);
                    }
                    
                    // Formatando totais de imoveis e de financiamentos
                    totalImoveisFormatado = formatterBRL.format(totalImoveis);
                    totalFinanciamentosFormatado = formatterBRL.format(totalFinanciamentos);
                    
                    System.out.println("Valor total dos imóveis: " + totalImoveisFormatado);
                    System.out.println("Valor total dos financiamentos: " + totalFinanciamentosFormatado);
                }
                case 3 -> {
                    // Pedindo valores ao usuário
                    double valorImovel = interfaceUsuario.pedirValorImovel();
                    double taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();
                    int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();

                    int tipoImovel = interfaceUsuario.pedirTipoImovel();

                    // Continuar dependendo do tipo do imóvel
                    switch (tipoImovel) {

                        // Casa
                        case 1 -> {
                            double areaTerreno = interfaceUsuario.pedirAreaTerreno();
                            double areaConstruida = interfaceUsuario.pedirAreaConstruida();
                            
                            Financiamento casa = new Casa(prazoFinanciamento, valorImovel, taxaJurosAnual, areaConstruida, areaTerreno, tipoImovel);
                            todosFinanciamentos.add(casa);
                        }

                        // Apartamento
                        case 2 -> {
                            int numerVagas = interfaceUsuario.pedirNumeroVagas();
                            int numeroAndar = interfaceUsuario.pedirNumeroAndar();

                            Financiamento apartamento = new Apartamento(prazoFinanciamento, valorImovel, taxaJurosAnual, numerVagas, numeroAndar, tipoImovel);
                            todosFinanciamentos.add(apartamento);
                        }

                        // Terreno
                        case 3 -> {
                            String tipoZona = interfaceUsuario.pedirTipoZona();

                            Financiamento terreno = new Terreno(prazoFinanciamento, valorImovel, taxaJurosAnual, tipoZona, tipoImovel);
                            todosFinanciamentos.add(terreno);
                        }
                    }

                    // Financiamentos escritos diretamente no código para avaliação do professor
                    
                    Financiamento Casa1 = new Casa(10, 1000000, 90, 50, 75, 1);
                    Financiamento Casa2 = new Casa(20, 2000000, 12,75, 100, 1);
                    Financiamento Apartamento1 = new Apartamento(30, 500000, 7, 1, 4, 2);
                    Financiamento Apartamento2 = new Apartamento(5, 200000, 8, 2, 8, 2);
                    Financiamento Terreno1 = new Terreno(50, 4000000, 14, "Comercial", 3);
                    Financiamento Terreno2 = new Terreno(60, 900000, 9, "Residencial", 3);
                    todosFinanciamentos.add(Casa1);
                    todosFinanciamentos.add(Casa2);
                    todosFinanciamentos.add(Apartamento1);
                    todosFinanciamentos.add(Apartamento2);
                    todosFinanciamentos.add(Terreno1);
                    todosFinanciamentos.add(Terreno2);

                    // Escrevendo financiamentos Serialized
                    interfaceUsuario.escreverDocumentoSerialized(todosFinanciamentos);

                    // Escrevendo financiamentos no aquivo de texto
                    interfaceUsuario.escreverDocumentoTexto(todosFinanciamentos);
                }

                // Sair
                case 4 -> {
                    continuar = false;
                    System.out.println("Até mais!");
                } 
            }
            
        } while (continuar);
    }
}
