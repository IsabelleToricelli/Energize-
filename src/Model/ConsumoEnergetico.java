package Model;

import java.util.Date;

public class ConsumoEnergetico {
    private int id_consumo;
    private int id_usuario;
    private double valorMensal;
    private double consumoKWh;
    private Date mes;

    public ConsumoEnergetico() {
    }

    public ConsumoEnergetico(int id_consumo, int id_usuario, double valorMensal, double consumoKWh, Date mes) {
        this.id_consumo = id_consumo;
        this.id_usuario = id_usuario;
        this.valorMensal = valorMensal;
        this.consumoKWh = consumoKWh;
        this.mes = mes;
    }

    public int getId_consumo() {
        return id_consumo;
    }

    public void setId_consumo(int id_consumo) {
        this.id_consumo = id_consumo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public double getConsumoKWh() {
        return consumoKWh;
    }

    public void setConsumoKWh(double consumoKWh) {
        this.consumoKWh = consumoKWh;
    }

    public Date getMes() {
        return mes;
    }

    public void setMes(Date mes) {
        this.mes = mes;
    }

    public void registrarConsumo(){
     System.out.println("Consumo de " + consumoKWh + "registrado para o usuário" + id_usuario
             +"\n Valor Mensal: "+ valorMensal + "\n"
     + "Mês: " + mes);

    }
}
