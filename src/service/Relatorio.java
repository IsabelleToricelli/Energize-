package service;

import Model.ConsumoEnergetico;

import java.util.ArrayList;

public class Relatorio {
    private int id_relatorio;
    private int id_usuario;
    private ArrayList<ConsumoEnergetico> historicoConsumo;
    private ArrayList<Sugestao> historicoSugestao;

    public Relatorio() {
    }

    public Relatorio(int id_relatorio, int id_usuario, ArrayList<ConsumoEnergetico> historicoConsumo, ArrayList<Sugestao> historicoSugestao) {
        this.id_relatorio = id_relatorio;
        this.id_usuario = id_usuario;
        this.historicoConsumo = historicoConsumo;
        this.historicoSugestao = historicoSugestao;
    }

    public int getId_relatorio() {
        return id_relatorio;
    }

    public void setId_relatorio(int id_relatorio) {
        this.id_relatorio = id_relatorio;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public ArrayList<ConsumoEnergetico> getHistoricoConsumo() {
        return historicoConsumo;
    }

    public void setHistoricoConsumo(ArrayList<ConsumoEnergetico> historicoConsumo) {
        this.historicoConsumo = historicoConsumo;
    }

    public ArrayList<Sugestao> getHistoricoSugestao() {
        return historicoSugestao;
    }

    public void setHistoricoSugestao(ArrayList<Sugestao> historicoSugestao) {
        this.historicoSugestao = historicoSugestao;
    }
    public void gerarRelatorio(){
        System.out.println("Relátorio para o usuário "+ id_usuario);
        for ( ConsumoEnergetico consumo:historicoConsumo){
            System.out.println("Consumo: "+ consumo.getConsumoKWh() + "KWh");
        }
        for(Sugestao sugestao: historicoSugestao){
            System.out.println("Sugestão: " + sugestao.getDescricao());
        }
    }

}
