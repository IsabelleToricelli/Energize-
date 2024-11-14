package Model;

public abstract class RecursoEnergetico {
    private int id_recurso;
    private double carbonoKWh;

    public RecursoEnergetico() {
    }

    public RecursoEnergetico(int id_recurso, double carbonoKWh) {
        this.id_recurso = id_recurso;
        this.carbonoKWh = carbonoKWh;
    }

    public int getId_recurso() {
        return id_recurso;
    }

    public void setId_recurso(int id_recurso) {
        this.id_recurso = id_recurso;
    }

    public double getCarbonoKWh() {
        return carbonoKWh;
    }

    public void setCarbonoKWh(double carbonoKWh) {
        this.carbonoKWh = carbonoKWh;
    }
    public void compararRecursos(RecursoEnergetico recursoEspecifico){
        if( this.carbonoKWh < recursoEspecifico.getCarbonoKWh()){
            System.out.println("Este recurso emite menos carbono por KWh");
        }else{
            System.out.println("Este recurso emite mais carbono por KWh");
        }

    }

    public abstract void compararRecursos();
}
