package Model;

public class Energia_Solar extends RecursoEnergetico {
    private double custoPainel;
    private double geracaoPainelKWh;



    public Energia_Solar(int id_recurso, double carbonoKWh, double custoPainel, double geracaoPainelKWh) {
        super(id_recurso, carbonoKWh);
        this.custoPainel = custoPainel;
        this.geracaoPainelKWh = geracaoPainelKWh;

    }

    public double getCustoPainel() {
        return custoPainel;
    }

    public void setCustoPainel(double custoPainel) {
        this.custoPainel = custoPainel;
    }

    public double getGeracaoPainelKWh() {
        return geracaoPainelKWh;
    }

    public void setGeracaoPainelKWh(double geracaoPainelKWh) {
        this.geracaoPainelKWh = geracaoPainelKWh;
    }
 @Override
    public void compararRecursos(){

 }


    }


