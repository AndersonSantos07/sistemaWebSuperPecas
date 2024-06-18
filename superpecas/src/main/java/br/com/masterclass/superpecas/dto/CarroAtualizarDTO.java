package br.com.masterclass.superpecas.dto;

public class CarroAtualizarDTO {

    private int id;
    private String modelo;
    private String fabricante;
    private String codigoUnico;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String toString(){
        return "modelo: " + this.getModelo() + " " +
                "fabricante: " + this.getFabricante() + " " +
                "código único: " + this.getCodigoUnico();
    }
}
