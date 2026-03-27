package modelo;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public abstract class Financiamento implements Serializable {

    // ID de versão serial
    private static final long serialVersionUID = 1L;

    // Atributos da classe abstrata
    protected int prazoFinanciamento;
    protected double valorImovel;
    protected double taxaJurosAnual;
    private double jurosPorcentagem;
    protected int tipoImovel;
    private double totalPagamento;
    private double valorMensal;

    // Getters
    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public int getTipoImovel() {
        return tipoImovel;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public double getJurosPorcentagem() {
        return jurosPorcentagem;
    }

    public double getTotalPagamento() {
        return totalPagamento;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    // Pegar dados do financiamento
    public String getDadosFinanciamento() {
        // Formatador de valores
        Locale localeBR = new Locale("pt", "BR");
        NumberFormat formatterBRL = NumberFormat.getCurrencyInstance(localeBR);

        String valorImovelFormatado = formatterBRL.format(getValorImovel());
        String totalPagamentoFormatado = formatterBRL.format(getTotalPagamento());
        String pagamentoMensalFormatado = formatterBRL.format(getValorMensal());
        String imovel = "";

        switch (getTipoImovel()) {
            case 1 -> imovel = "Casa";
            case 2 -> imovel = "Apartamento";
            case 3 -> imovel = "Terreno";
        }

        return  imovel + ", valor do Imóvel: " + valorImovelFormatado + " | em " + getPrazoFinanciamento() + " anos a uma taxa de " + getJurosPorcentagem() + "% a.a | Total do financiamento: " + totalPagamentoFormatado + " ou " + pagamentoMensalFormatado + " ao mês.";
    }

    // Contrutor da classe
    public Financiamento(int prazoFinanciamento, double valorImovel, double taxaJurosAnual, int tipoImovel) {
        this.prazoFinanciamento = prazoFinanciamento;
        this.valorImovel = valorImovel;
        this.taxaJurosAnual = taxaJurosAnual / 100;
        this.jurosPorcentagem = taxaJurosAnual;
        this.tipoImovel = tipoImovel;
        totalPagamento();
    }

    // Método abstrato para todas as classes concretas implementarem
    public abstract double calcularValorMensal();

    // Valor total do financiamento
    public void totalPagamento() {
        this.totalPagamento = (this.calcularValorMensal() * this.prazoFinanciamento * 12);
        this.valorMensal = this.calcularValorMensal();
    }
}
