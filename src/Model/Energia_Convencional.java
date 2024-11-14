package Model;

public class Energia_Convencional extends RecursoEnergetico{
    private double custoKWh;

    public Energia_Convencional(int id_recurso, double carbonoKWh, double custoKWh) {
        super(id_recurso, carbonoKWh);
        this.custoKWh = custoKWh;
    }

    public double getCustoKWh() {
        return custoKWh;
    }

    public void setCustoKWh(double custoKWh) {
        this.custoKWh = custoKWh;
    }
    @Override
    public void compararRecursos(){
    }
}
