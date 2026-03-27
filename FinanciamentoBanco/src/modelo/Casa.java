package modelo;

import util.AcrescimoMaiorDoQueJurosException;

public class Casa extends Financiamento {

    // Atributos da classe
    private double areaConstruida;
    private double areaTerreno;

    // Getters
    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getAreaTerreno() {
        return areaTerreno;
    }
    
    // Construtor da classe
    public Casa(int prazoFinanciamento, double valorImovel, double taxaJurosAnual, double areaConstruida, double areaTerreno, int tipoImovel) {
        super(prazoFinanciamento, valorImovel, taxaJurosAnual, tipoImovel);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    // Implementação da classe abstrata para calcular o valor mensal
    @Override
    public double calcularValorMensal() {
        double parcelaBase = (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + (getTaxaJurosAnual() / 12));
        double juros = parcelaBase - (getValorImovel() / (getPrazoFinanciamento() * 12));

        double acrescimo = 80;

        // Validar Exception
        try {
            validarAcrescimoMaiorQueJuros(juros, acrescimo);
        } catch (AcrescimoMaiorDoQueJurosException e) {
            System.out.println(e.getMessage());
            acrescimo = juros;
        }

        return parcelaBase + acrescimo;
    }

    // Validar Exception
    private void validarAcrescimoMaiorQueJuros(double juros, double acrescimo) throws AcrescimoMaiorDoQueJurosException {
        if (acrescimo > (juros / 2)) {
            throw new AcrescimoMaiorDoQueJurosException("O valor do acréscimo ficou maior que o valor dos juros, novo valor de acréscimo é igual ao valor de juros mensais");
        }
    }

    // Especificar os dados do financiamento para esse tipo de imóvel
    @Override
    public String getDadosFinanciamento() {
        return super.getDadosFinanciamento() + " Área construída: " + getAreaConstruida() + "m², área do terreno: " + getAreaTerreno() + "m²";
    }
}
