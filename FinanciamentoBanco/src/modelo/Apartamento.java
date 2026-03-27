package modelo;

public class Apartamento extends Financiamento {
    
    // Atributos da classe
    private int numeroVagas;
    private int numeroAndar;

    // Construtor da classe
    public Apartamento(int prazoFinanciamento, double valorImovel, double taxaJurosAnual, int numeroVagas, int numeroAndar, int tipoImovel) {
        super(prazoFinanciamento, valorImovel, taxaJurosAnual, tipoImovel);
        this.numeroVagas = numeroVagas;
        this.numeroAndar = numeroAndar;
    }

    // Getters
    public int getNumeroVagas() {
        return numeroVagas;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }
    
    // Implementação da classe abstrata para calcular o valor mensal
    @Override
    public double calcularValorMensal() {
        double taxaJurosMensal = getTaxaJurosAnual() / 12;
        int prazoFinanciamentoMeses = getPrazoFinanciamento() * 12;

        return (getValorImovel() * Math.pow((1 + taxaJurosMensal), prazoFinanciamentoMeses)) / (Math.pow((1 + taxaJurosMensal), prazoFinanciamentoMeses) - 1);
    }

    // Especificar os dados do financiamento para esse tipo de imóvel
    @Override
    public String getDadosFinanciamento() {
        return super.getDadosFinanciamento() + ", " + getNumeroAndar() + "° andar, " + getNumeroVagas() + " vagas";
    }
}
