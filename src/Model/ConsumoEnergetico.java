package Model;

import exception.CustomException;
import java.util.Date;

public class ConsumoEnergetico {
    private int id_consumo;
    private int id_usuario;
    private double valorMensal;
    private double consumoKWh;
    private Date mes;

    public ConsumoEnergetico() {
    }

    public ConsumoEnergetico(int id_consumo, int id_usuario, double valorMensal, double consumoKWh, Date mes) throws CustomException {
        if (consumoKWh <= 0 && valorMensal < 0) {
            throw new CustomException("Consumo de energia e o valor mensal devem ser positivos.");
        }
        if (mes == null) {
            throw new CustomException("Data do mês não pode ser nula.");
        }
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

    public void setValorMensal(double valorMensal) throws CustomException {
        this.valorMensal = valorMensal;
    }

    public double getConsumoKWh() {
        return consumoKWh;
    }

    public void setConsumoKWh(double consumoKWh) throws CustomException {
        this.consumoKWh = consumoKWh;
    }

    public Date getMes() {
        return mes;
    }

    public void setMes(Date mes) throws CustomException {
        if (mes == null) {
            throw new CustomException("Data do mês não pode ser nula.");
        }
        this.mes = mes;
    }

    public void registrarConsumo() {
        try {
            System.out.println("Consumo de " + consumoKWh + " registrado para o usuário " + id_usuario
                    + "\n Valor Mensal: " + valorMensal + "\n" + "Mês: " + mes);
        } catch (Exception e) {
            System.err.println("Erro ao registrar consumo: " + e.getMessage());
        }
    }
}
