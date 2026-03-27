package modelo;

public class Terreno extends Financiamento {
    
    // Atributo da classe
    private String tipoZona;

    // Getters
    public String getTipoZona() {
        return tipoZona;
    }

    // Construtor da classe
    public Terreno(int prazoFinanciamento, double valorImovel, double taxaJurosAnual, String tipoZona, int tipoImovel) {
        super(prazoFinanciamento, valorImovel, taxaJurosAnual, tipoImovel);
        this.tipoZona = tipoZona;
    }
    
    // Implementação da classe abstrata para calcular o valor mensal
    @Override
    public double calcularValorMensal() {
        return (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + (getTaxaJurosAnual() / 12)) + (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + (getTaxaJurosAnual() / 12)) * 0.02;
    }

    // Especificar os dados do financiamento para esse tipo de imóvel
    @Override
    public String getDadosFinanciamento() {
        return super.getDadosFinanciamento() + ", zona " + getTipoZona();
    }
}
