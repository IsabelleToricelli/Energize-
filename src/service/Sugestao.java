package service;

import Model.ConsumoEnergetico;

public class Sugestao {
    private int id_sugestao;
    private ConsumoEnergetico consumoEnergetico;
    private double carbonoEvitado;
    private double economiaMensal;
    private String descricao;

    public Sugestao() {
    }

    public Sugestao(int id_sugestao, ConsumoEnergetico consumoEnergetico, double carbonoEvitado,
                    double economiaMensal, String descricao) {
        this.id_sugestao = id_sugestao;
        this.consumoEnergetico = consumoEnergetico;
        this.carbonoEvitado = carbonoEvitado;
        this.economiaMensal = economiaMensal;
        this.descricao = descricao;
    }

    public int getId_sugestao() {
        return id_sugestao;
    }

    public void setId_sugestao(int id_sugestao) {
        this.id_sugestao = id_sugestao;
    }

    public ConsumoEnergetico getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(ConsumoEnergetico consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public double getCarbonoEvitado() {
        return carbonoEvitado;
    }

    public void setCarbonoEvitado(double carbonoEvitado) {
        this.carbonoEvitado = carbonoEvitado;
    }

    public double getEconomiaMensal() {
        return economiaMensal;
    }

    public void setEconomiaMensal(double economiaMensal) {
        this.economiaMensal = economiaMensal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescrição(String descricao) {
        this.descricao = descricao;
    }

    public void gerarSugestao(ConsumoEnergetico consumo){
        this.descricao = "Considerar a instalação de painéis solares para economizar energia " +
                "e diminuir a emissão de carbono.";
        this.carbonoEvitado = consumo.getConsumoKWh()*0.5;
        this.economiaMensal = consumo.getValorMensal()*0.2;
        System.out.println("Sugestão gerada " + descricao + "\n Seria evitado a emissão de "+ carbonoEvitado+ "g de gás carbono"
        + "\n Economizaria R$"+ economiaMensal + "por mês de consumo de Energia");


    }
}
