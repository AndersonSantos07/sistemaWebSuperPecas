package br.com.masterclass.superpecas.dto;

import br.com.masterclass.superpecas.model.CarrosModel;

public class PecaAtualizarDTO {

    private int id;
    private String nome;
    private String desc;
    private String numSerie;
    private String fabricante;
    private String modeloCarro;
    private int carroID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public int getCarroID() {
        return carroID;
    }

    public void setCarroID(int carroID) {
        this.carroID = carroID;
    }

    @Override
    public String toString(){
        return "nome: " + this.getNome() + " " +
                "descrição: " + this.getDesc() + " " +
                "num série: " + this.getNumSerie() + " " +
                "fabricante: " + this.getFabricante() + " " +
                "modelo carro: " + this.getModeloCarro();
    }
}
